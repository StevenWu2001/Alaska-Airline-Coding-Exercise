# Alaska-Airline-Coding-Exercise (Steven Wu)
I am using Java for this exercise. The method ```maxFamilySeats``` inside the ```Solution``` class implements the solution. I also included a file that I used to test the program.

### Questions
The instruction says there are only 5 rows on this plane. I wonder for this problem if we should consider potentially more rows, even though it is not stated in the problem.

### My Assumptions
My assumption that reserved seats are all valid and distict had been stated in the instruction.

I also assumed that each row will only have 10 seats (with 2 aisles in between) as the instruction mentioned.

### Different Solution Paths
I feel like this is a very interesting problem. At the first glance, it really doesn't seem that hard, since the instrustions are clear and the goal is simple. But as I start working on it, many different issues and potential pitfalls (like runtime, space usuage, implementation, etc.) popped up in my mind and I thought about it for a good while.

The first solution I coded was sort of a fixed-size sliding window approach (it actually is just brute force :)). In this approach, we have a 2D array storing all the seats, and we will first filled the reserved seats from the input string. Then, the window size is fixed at 4 (size of the family) and we will slide the window accross each row. If a window can fit a family, we will move on to the next window by skipping the entire current one; otherwise we will just increase the left and right pointers. This approach takes ```O(N * M)``` time and uses ```O(N * M)``` space, where N and M are number of rows and columns, because we need to store all the seats and visit them at least once.

This solution does work but both the runtime and space usage are kind of bad. I decided to change it. One way to improve this solution is to run sliding window only on occupied rows so it will be more efficient (since we already know that an empty row can fit 2 families). We can also sort the reserved seats so then we don't have to store all the seats. But doing so makes the implementation more annoying and the code soon becomes messy. To solve this particular problem, I'm looking for a more elegent solution.

Two important things to note are that, there are only 3 possible options to fit a family in a row, ```B-E```, ```D-G```, and ```F-J```; and an empty row can fit 2 families as mentioned before. Thus, the second solution I had uses bitwise operations to track and change the status of an occupied row, while ignoring unoccupied ones. 3 bit values can represent the availability of these 3 options. For example, ```0b111``` represents all 3 are available, while ```0b000``` represents none of them are available. After processing the reserved seats and computing a binary value (represented using byte in Java) for each occupied row, we will then go through each of them to figure out how many families it can fit. In this problem, there are only two cases when we can fit 2 families in a row, ```0b111``` and ```0b101```; any other values greater than 1 will fit only 1 family; if the bit value is 0, no familiy can be seated in this row.

This solution improves both the runtime and space usage. It takes ```O(N)``` time and uses ```O(M)``` space, where N is the number of reserved seats and M is the number of occupied rows.

Of course, we can "optimize" this solution even more so it uses ```O(1)``` constant space. In order to achieve this, we can sort the reserved seats before processing it so that we can sequentially iterate through each occupied row, without the need to store all of them. However, doing so increases the runtime to ```O(Nlog(N))``` because sorting is needed. Therefore, I decided not to use the optimization in order to keep the linear runtime.
