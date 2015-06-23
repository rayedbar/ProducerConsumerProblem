# Producer Consumer Problem

Problem Statement:

Consider the classical producer-consumer problem, where two processes share a common fixed-size buffer. One of them producer, puts the information into the buffer, and the other one , consumer, takes it out. Trouble arises when the producer wants to put data into the buffer but it is already full. The solution is for the producer to go to sleep, to be awakened when the consumer has removed one or more items. Similarly when the consumer wants to remove an item from the buffer and sees that buffer is empty, it goes to sleep until the producer puts something in the buffer and wakes the consumer up. Write a Java program to solve the above mentioned producer-consumer problem.

Solution powered by Intelli J.
