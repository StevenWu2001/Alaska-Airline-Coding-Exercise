# Alaska-Airline-Coding-Exercise
### Questions

### My Assumptions


### Different Solution Paths
I feel like this is a very interesting problem. At the first glance, it really doesn't seem that hard, since the instrustions are clear and the goal is simple. But as I start working on it, many different ideas and potential pitfalls (like runtime, space usuage, implementation, etc.) popped up in my mind and I thought about it for a good while.

The first solution I coded was sort of a fixed size sliding window approach (brute force ish? I guess). In this approach, we have a 2D array storing all the seats and we will first filled the reserved seats from the input string. Then, the window size is fixed at 4 (size of the family) and we will slide the window accross each row. Since we are looking for the maximum possible four-person families, we can record it as soon as we find a window that satisfies all the conditions (i.e. 4 seats next to each other, or divided equally by an aisle). This approach takes ```O(N * M)``` time and uses ```O(N * M)``` space, where N and M are number of rows and columns, because we need to store all the seats and visit them at least once.

This solution does work but both runtime and space are kind of bad. I decided to change it. A way to improve this solution is to run sliding window only on occupied rows so it will be more efficient (since we already know that an empty row can fit 2 families). But doing so makes the implementation a little more annoying. To solve this particular problem, I'm looking for a more elegent solution.

Two important things to note are that, there are only 3 possible options to fit a family in a row, ```B-E```, ```D-G```, and ```F-J```; and an empty row can fit 2 families. Thus, the second solution I had uses bitwise operations to track the status of an occupied row, while ignoring unoccupied ones. 3 bit values can represent the availability of these 3 options. For example, ```0b111``` represents all 3 are available, while ```0b000``` represents none of them are available.
