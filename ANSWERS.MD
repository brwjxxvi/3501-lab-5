3) Because the for loop that creates satisfactory pairings starts over when a swap is made, there is concern about infinite looping. Forunately, this cannot occur 
because the loop only restarts when there exists two partnerships (1, A) and (2, B) such that B prefers 1 to it's current programmer (2) and 1 prefers B to its current 
company. This would result in the pairs (1,B) and (2,A). From this point, the loop couldn't restart we already have satisfactory pairing. This stringent condition for 
swapping prevents infinite looping.

4) The worst-case effciency of the algorithm is O(n^3) because the first for-loop runs n times where n=the number of programmers/companies, the second for-loop also runs 
n times, with an internal for-loop that runs d*n times where d is a constant > 0, and inside this for-loop, we make several calls to helper functions which also have a 
run time of O(n) making the runtime of the internal for-loop n * 3n (3 being the number of calls we make to runtime n helperfunctions). That gives us a runtime of g*n^3 
for the nested for-loop. This dominates the run-time of the algorithm meaning the overall runtime is O(n^3).
