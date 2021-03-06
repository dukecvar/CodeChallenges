# Code Challenges

Repo for some code challenges. These are retrospectives after
taking a code challenges for recent interviews using Codility 
for LiveRamp.

### Build
`./gradlew build`

## MaxSpike
For an array of unsorted integers, find the longest length of
digits that forms a spike. A spike is such that the beginning
strictly increases, reaches a peak and then strictly decreases.
A series that only increases is still a spike.  

Examples:
```
Input: {3, 9, 6, 8, 1, 2, 7, 4}
Longest spike series: {1, 2, 3, 4, 6, 7, 8, 9} (all increasing)
Max Spike: 8

Input: { 3, 3, 3}
Longest spike series: {3}
Max Spike: 1

Input: {2, 1, 3, 2, 2, 1, 1, 1, 3, 3}
Longest spike series: {1, 2, 3, 2, 1}
Max Spike: 5

Input: {2, 1, 1}
Longest spike series: {1, 2, 1}
Max Spike: 3

Input: {2, 1, 2}
Longest spike series: {1, 2}
Max Spike: 2
```

### Notes
The original problem was part of a timed test taken on Codility.
As part of the solution, I java's PriorityQueue for a Max Heap.
It ran just fine but upon submission, it only scored a 75%.  For
a large dataset, using the PriorityQueue does not perform well
for several reasons.  First, loading it took N log N operations
which is expected performance for insert in a MaxHeap but this process
is making a copy the entire input.  Second,PriorityQueue is a
balanced binary heap; a fibonacci heap might perform better.  I
found writing a zero index based MaxHeap implementation on the
input array performed at least 2 times faster on large sets with
lots of duplication but at least 4x better
than PriorityQueue as the sample set became more unique
(based on random numbers generated by min & max range). The
application's main demonstrates this:

Output of each line:
>$1, $2, $3, $4, $5

where

$1: number of values in array  
$2: min range  
$3: max range  
$4: millisecond runtime using zero based index array  
$5: millisecond runtime using PriorityQueue  

### Run
`./run maxspike`

---
## Bowling
Design a program that follows a game of bowling that allows
a player to roll a ball (integer between 0 & 10 inclusively)
and track the score.

This was another Codility program using codility but this
time /during/ the interview which was far more collaborative
than MaxSpike.  Codility's requirement was to implement 2 functions:
``roll($pins)`` and ``score()`` which would return the current score.
It was fun enough, so I took it a bit further and changed the input to
use the console and output via JSON.  After each, the output will
reflect the rolls and score of the game (score is in parens if
score hasn't yet been tallied for that frame).

### Run it
`./run bowling`

This line left confusing and needless on purpose.

