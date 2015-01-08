package ua.epam.sergiishapoval.homework.hw12.skipmap;

import java.util.Arrays;

/**
 * Created by Сергей on 23.11.2014.
 */
public class SkipListWithWidth {
    private class ListNode
    {
        public int Element;
        public ListNode Next;
        private ListNode() {
        }

        public ListNode(int element){
            Element = element;
        }

        private ListNode(int element, ListNode next) {
            Element = element;
            Next = next;
        }

        @Override
        public String toString() {
            return Element + "";
        }
    }

    private class Lane
    {
        public final ListNode Node;
        public final Lane Down;
        public Lane Right;
//width = distance to next Lane element in a node list
//        public int Width;

        public Lane(ListNode node){
            this(node, null, null
//                    , 1
            );
        }

        private Lane(ListNode node, Lane down) {
            this(node, down, null
//                    , 1
            );
        }

        private Lane(ListNode node, Lane down, Lane right
//                , int width
        ) {
            Node = node;
            Down = down;
            Right = right;
//            Width = width;
        }

        @Override
        public String toString() {
            return "Lane{" +
                    "node=" + Node +
                    '}';
        }
    }


// MaxLevel (2^32 contains all positive integers )
    private final static int MaxLevel = 32;
//    existent Lanes
    private final Lane[] lanes = new Lane[MaxLevel + 1];
//
//    private final int[] steps = new int[MaxLevel + 1];
//    Lanes to be updated
    private final Lane[] update = new Lane[MaxLevel + 1];
//    begin pointer
    private Lane headLane = new Lane(new ListNode());
//    initial level
    private int level = 1;

    public SkipListWithWidth() {
    }

    public void Add(int element)
    {

        ListNode predecessor = configureBuildingElements(element);
//        Adding to Nodes list
        ListNode newNode = new ListNode(element, predecessor.Next);
        predecessor.Next = newNode;
//  Update levels
        int newLevel = getNewLevel();
        if (newLevel > level){
            newLevel = level + 1;
            headLane = update[newLevel] = new Lane(headLane.Node, headLane);
            level = newLevel;
        }
//clear lanes before update
        lanes[0] = null;
        AddLane(newLevel, newNode);
        System.out.println("Current lanes: " + Arrays.asList(lanes));
    }

    private int getNewLevel() {
        int newLevel = 0;
        while (Math.random() < 0.5 && level < MaxLevel)
            ++newLevel;
        return newLevel;
    }

    private ListNode configureBuildingElements(int element){
        Lane lane = headLane;
//while not in the node line
        for (int currentLevel = level; currentLevel > 0; --currentLevel){
//clear steps
//            steps[currentLevel] = 0;
//while not is maximum is this Lane, go right, remember distance
            while (lane.Right != null && lane.Right.Node.Element <= element){
//                steps[currentLevel] += lane.Width;
                lane = lane.Right;
            }
//save Lane to change at this level
            update[currentLevel] = lane;
            lane = lane.Down;
        }
//move in the basis Line
        ListNode node = update[1].Node;
//        steps[0] = 0;
        while (node.Next != null && node.Next.Element <= element){
//            ++steps[0];
            node = node.Next;
        }

//log
//        printStepsArray();
        System.out.println("Update array: " + Arrays.asList(update));

        return node;
    }


/*
    private void printStepsArray() {
        System.out.print("Steps array: [");
        for (int i : steps){
            System.out.print(i + ", ");
        }
        System.out.println("]");
    }
*/

    private void AddLane(int laneLevel, ListNode newNode){
//        int currentSteps = steps[0];
        for (int currentLevel = 1; currentLevel <= laneLevel; ++currentLevel){
            Lane updateLane = update[currentLevel];
            lanes[currentLevel] = new Lane(newNode, lanes[currentLevel - 1], updateLane.Right
//                    ,
//                    updateLane.Width - currentSteps
            );
            updateLane.Right = lanes[currentLevel];
//            updateLane.Width = currentSteps + 1;
//            currentSteps += steps[currentLevel];
        }
//        increase width of each level above current
//        for (int currentLevel = laneLevel + 1; currentLevel <= level; ++currentLevel)
//            ++update[currentLevel].Width;
    }
}

    
    
    
