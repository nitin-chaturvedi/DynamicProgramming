# DynamicProgramming
The repo has some sample dynamic programming questions in java

# Java programming tips

## Arrays
initialize
new int[size]
new int[]{1,2,3}

Arrays.toString(arr)//for 1d array string

Arrays.deepToString(arr)//for aray of array string

Arrays.copyOfRange(orginal,from,to);// to create subarray copy

## Maps
initialize with value
new HashMap<String, String>() {{
put("key1", "value1");
put("key2", "value2");
}};

//java11
new HashMap<String, String> (
Map.of("key1","value1", "key2", "value2"));//10 pairs

map.put(key,map.getOrDefault(key,0)+1);//to check add and increment value in 1 line

## Queue
priority queue act as heap default min heap use collection.reverse for max heap
use linkedlist for simple queue

Queue q = new PriorityQueue(Collections.reverseOrder());
q.add()
q.remove()

## Stack
Stack s = new Stack();
s.push()
pop
peek





