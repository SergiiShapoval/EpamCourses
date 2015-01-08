package ua.epam.sergiishapoval.projects.strings.taskentities;

/**
 * Created by Сергей on 06.11.2014.
 */
public enum Punctuation {

    EXCLAMATION('!'),
    DOT('.'),
    QUESTION('?'),
    NEWLINE('\n'),
    CARRET('\r'),
    TWO_DOT('‥'),
    HORIZONTAL_ELLIPSIS('…'),
    INTERROBANG('\u2048'),
    DISAMBIGUATION('\u2047'),
    NUMBERSIGN('#'),
    DOLLAR('$'),
    PERCENT('%'),
    AMPERSAND('&'),
    LBRACKETS('('),
    RBRACKETS(')'),
    ASTERISK('*'),
    PLUS('+'),
    COMMA(','),
    COMMA2(','),
    SPACE(' '),
    MINUS('-'),
    SLASH('/'),
    COLON(':'),
    SEMICOLON(';'),
    LESSTHAN('<'),
    EQUAL('='),
    GREATERTHAN('>'),
    LSQUAREBRACKETS('['),
    RSQUAREBRACKETS(']'),
    CARET('^'),
    UNDERSCORE('_'),
    GRAVIS('`'),
    LCURLYBRACKETS('{'),
    VERTICALBAR('|'),
    RCURLYBRACKETS('}'),
    TILDE('~'),
    DASH('‒'),
    GDASH('—'),
    GIANTDASH('―'),
    MULTIPLICATION('×'),
    PER_MILLE('‰'),
    PER_TEN_THOUSAND('‱'),
    QUOTATION('"'),
    LEFT_POINTING_DOUBLE_ANGLE_QUOTATION('«'),
    RIGHT_POINTING_DOUBLE_ANGLE_QUOTATION('»'),
    LEFT_SINGLE_QUOTATION('‘'),
    RIGHT_SINGLE_QUOTATION('’'),
    SINGLE_LOW_9_QUOTATION_MARK('‚'),
    SINGLE_HIGH_REVERSED_9_QUOTATION('‛'),
    LEFT_DOUBLE_QUOTATION('“'),
    RIGHT_DOUBLE_QUOTATION('”'),
    DOUBLE_LOW_9_QUOTATION('„'),
    DOUBLE_HIGH_REVERSED_9_QUOTATION('‟'),
    SINGLE_LEFT_POINTING_ANGLE_QUOTATION('‹'),
    SINGLE_RIGHT_POINTING_ANGLE_QUOTATION('›'),
    BACKSLASH('\\');


    private char sign;

    private Punctuation(char sign) {
        this.sign = sign;
    }

    public char getSign() {
        return this.sign;
    }
}
