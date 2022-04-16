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

System.arraycopy(source,sourceStart,destination,destStart,source.length);

//Array to array list : - 
Arrays.stream(combinationNew).boxed().collect(Collectors.toList());

//list to int array : - 
l.stream().mapToInt(i ->i).toArray()

## Maps
initialize with value
new HashMap<String, String>() {{
put("key1", "value1");
put("key2", "value2");
}};

//java11(9+)

new HashMap<String, String> (
Map.of("key1","value1", "key2", "value2"));//10 pairs

Map<String, String> test2 = Map.ofEntries(
entry("a", "b"),
entry("c", "d")
);

map.put(key,map.getOrDefault(key,0)+1);//to check add and increment value in 1 line

## Queue
priority queue act as heap default min heap use collection.reverse for max heap
use linkedlist for simple queue

Queue q = new PriorityQueue(Collections.reverseOrder());
q.add()
q.remove()

## String
startsWith

substring(begin,end)

## Stack
Stack s = new Stack();
s.push()
pop
peek





