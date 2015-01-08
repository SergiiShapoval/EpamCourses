package ua.sergiishapoval.tag;

import com.sun.deploy.net.HttpRequest;
import ua.sergiishapoval.model.Countries;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by Сергей on 17.12.2014.
 */
public class ForEachTagImpl extends BodyTagSupport {
    Object id;

    public void setId(Object id) {
        this.id = id;
    }

    String var;

    public void setVar(String var) {
        this.var = var;
    }

    Iterator<Object> iterator;


    @Override
    public int doStartTag ()throws JspException {
        if (iterator == null) {
            if (id instanceof Object[]) {
                iterator = Arrays.asList((Object[]) id).iterator();
            } else {
                if (id instanceof Collection){
                    iterator = ((Collection) id).iterator();
                }
            }
            HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
            request.setAttribute(var, iterator.next());
        }
        return EVAL_BODY_INCLUDE;
    }

    @Override
    public int doAfterBody() throws JspException {
        if (iterator.hasNext()) {
            pageContext.getRequest().setAttribute(var, iterator.next() );
            return EVAL_BODY_AGAIN;
        } else {
            iterator = null;
            return SKIP_BODY;
        }
    }

    @Override
    public int doEndTag ()throws JspException {
        pageContext.getRequest().setAttribute(var, null);
        return EVAL_PAGE;
    }
}