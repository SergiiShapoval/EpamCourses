package ua.epam.sergiishapoval.homework.hw12.skipmap;

import java.util.Arrays;

/**
 * Created by Сергей on 21.11.2014.
 * Предложить собственную реализацию ConcurrentSkipListMap
 * http://habrahabr.ru/post/139870/
 * https://www.youtube.com/watch?v=Dx7Hk8-8Kdw
 * http://www.cse.yorku.ca/~billk/Teaching/lectureNotes_04_26.pdf
 * https://ru.wikipedia.org/wiki/%D0%A1%D0%BF%D0%B8%D1%81%D0%BE%D0%BA_%D1%81_%D0%BF%D1%80%D0%BE%D0%BF%D1%83%D1%81%D0%BA%D0%B0%D0%BC%D0%B8
 *
 * Important points
 * all k,v pairs represented by linked nodes;
 * above nodes - lanes;
 * levels calculated until no more than level
 * special array for lane and update
 * move from top to nodes filling update
 * move from node to top to update lanes
 */

public class MySkipList {

    private class ListNode
    {
        public Integer key;
        public Integer value;

        public ListNode next;
        private ListNode() {
        }

        public ListNode(Integer key, Integer value){
            this(key, value, null);
        }

        private ListNode(Integer key, Integer value, ListNode next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            return "(" + key + " : " + value + ')';
        }
    }

    private class Lane
    {
        public final ListNode node;
        public final Lane down;
        public Lane right;

        public Lane(ListNode node){
            this(node, null, null);
        }

        private Lane(ListNode node, Lane down) {
            this(node, down, null);
        }

        private Lane(ListNode node, Lane down, Lane right) {
            this.node = node;
            this.down = down;
            this.right = right;
        }

        @Override
        public String toString() {
            return "Lane{" +
                    "node=" + node +
                    '}';
        }
    }


    private final static int initialMaxLevel = 32;
    //    existent Lanes
    private Lane[] lanes = new Lane[initialMaxLevel];
    //    Lanes to be updated
    private Lane[] update = new Lane[initialMaxLevel];
    //    begin pointer
    private Lane headLane = new Lane(new ListNode());
    //    initial level
    private int level = 1;



    private int size;

    public int size() {
        return size;
    }

    public MySkipList() {
    }

    public synchronized void put(Integer key, Integer value){
        ListNode predecessor = configureBuildingElements(key);
//Adding to Nodes list
        if (predecessor.key != null &&  predecessor.key.compareTo(key) == 0){
            predecessor.value = value;
        } else {
            size++;
            ListNode newNode = new ListNode(key, value, predecessor.next);
            predecessor.next = newNode;
//Update levels
            int newLevel = getNewLevel();
            if (newLevel > level) {

                newLevel = level + 1;
                headLane = update[newLevel] = new Lane(headLane.node, headLane);
                level = newLevel;

// fix arrays to store temp data
                if (level > lanes.length) {
                    lanes = Arrays.copyOf(lanes, lanes.length << 2);
                    update = Arrays.copyOf(update, lanes.length);
                }
            }
//clear lanes before update
            lanes[0] = null;
            addLane(newLevel, newNode);
        }
        System.out.println("Current lanes: " + Arrays.asList(lanes));
    }

    private int getNewLevel() {
        int newLevel = 0;
        while (Math.random() < 0.5 && newLevel <= level)
            ++newLevel;
        return newLevel;
    }

    private ListNode configureBuildingElements(Integer key){
        Lane lane = headLane;
//while not in the node line
        for (int currentLevel = level; currentLevel > 0; --currentLevel){
//while not is maximum is this Lane, go right, remember distance
            while (lane.right != null && lane.right.node.key.compareTo(key) <= 0){
                lane = lane.right;
            }
            update[currentLevel] = lane;
            lane = lane.down;
        }
        ListNode node = update[1].node;
        while (node.next != null && node.next.key.compareTo(key) <= 0){
            node = node.next;
        }

        System.out.println("Update array: " + Arrays.asList(update));

        return node;
    }

    private  void addLane(int laneLevel, ListNode newNode){
        for (int currentLevel = 1; currentLevel <= laneLevel; ++currentLevel){
            Lane updateLane = update[currentLevel];
            lanes[currentLevel] = new Lane(newNode, lanes[currentLevel - 1], updateLane.right);
            updateLane.right = lanes[currentLevel];
        }
    }


    public Integer get(Integer key){
        Lane lane = headLane;
        Lane previousLane = lane;
//while not in the node line
        for (int currentLevel = level; currentLevel > 0; --currentLevel){
            previousLane = lane;
//while not is maximum is this Lane, go right, remember distance
            while (lane.right != null && lane.right.node.key.compareTo(key) <= 0){
                lane = lane.right;
            }
            lane = lane.down;
        }
        ListNode node = previousLane.node;
        while (node.next != null && node.next.key.compareTo(key) <= 0){
            node = node.next;
        }
        return node.value;
    }

    public synchronized Integer remove(Integer key){
        Lane lane = headLane;
        Lane previousLane = lane;

        Integer result = null;
        boolean isKeyFound = false;

//while not in the node line
        for (int currentLevel = level; currentLevel > 0; --currentLevel){
            previousLane = lane;
//while not is maximum is this Lane, go right, remember distance
            while (lane.right != null && lane.right.node.key.compareTo(key) <= 0){
                previousLane = lane;
                lane = lane.right;
            }
//important check of null for head Lane;
            if (lane.node.key != null &&  key.compareTo(lane.node.key) == 0){
                if (!isKeyFound){
                    result = lane.node.value;
                    lane.node.value = null;
                    isKeyFound = true;
                }

                previousLane.right = lane.right;
                lane = previousLane.down;
            } else {
                lane = lane.down;
            }
        }

        ListNode node = previousLane.node;
        ListNode previousNode = node;



        while (node.next != null && node.next.key.compareTo(key) <= 0){
            previousNode = node;
            node = node.next;
            if (node.key.compareTo(key) == 0){
                break;
            }
        }
        previousNode.next = node.next;

        return result;
    }


    @Override
    public String toString() {

        if (headLane.node == null) return "{}";
        else {
            StringBuilder builder = new StringBuilder();


            ListNode currentNode = headLane.node.next;


            builder.append("{");
            boolean isFirst = true;
            while (currentNode != null) {
                if (isFirst) {
                    isFirst = false;
                } else {
                    builder.append(", ");
                }
                builder.append(currentNode);
                currentNode = currentNode.next;
            }

            builder.append("}");

            return builder.toString();
        }
    }
}








