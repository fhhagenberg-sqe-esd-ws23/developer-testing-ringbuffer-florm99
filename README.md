# Developer Testing with JUnit 

This exercise introduces how testing is done by developers and using the JUnit test framework for unit testing.

The implementation of a _RingBuffer_ (from the draft version of Introduction to Programming in Java: An Interdisciplinary Approach, R. Sedgewick and K. Wayne, Addison-Wesley, 2008) is the class under  test.

## Create RingBufferTest _(2 points)_

The task is to write 3 unit tests for the class RingBuffer. The goal is not to write many unit tests but to write useful unit tests that correctly use the [JUnit framework](https://junit.org/junit5/docs/current/user-guide/#writing-tests).

### Instructions

- Name the test class containing the tests `at.fhhagenberg.sqe.RingBufferTest` and put it into the folder `src/test/java`.
- The test cases (test methods in the class `RingBufferTest`) should test different aspects/features of the implementation. Try to find positive test cases that show the typical behavior of a ring buffer.
- Name each test method with the prefix _test<MethodName>_ (e.g., `testFooBar()`).
- If you find a bug in the implementation of RingBuffer, demonstrate it by a failing (red) test.

> Run your tests with `mvn test` in a new shell. The result should be similar to:

```
-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running at.fhhagenberg.sqe.RingBufferTest
Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.016 sec

Results :
Tests run: 3, Failures: 0, Errors: 0, Skipped: 0

[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  6.837 s
[INFO] Finished at: 2021-10-02T09:17:44+02:00
[INFO] ------------------------------------------------------------------------
```

### Submission

When you're done...

- [x] push your changes to your upstream repository on GitHub.
- [x] on GitHub, [create a release][GitHub creating releases] with version `v0.1`.
- [x] upload the [link to your release][GitHub linking to releases] on the e-learning platform until the specified date and time before the next lecture.
- [x] Only complete submissions adhering to all of the above requirements are considered. Late submissions, submissions via email or submissions failing to meet the specified requirements will not be accepted.

## EmptyRingBufferTest _(1 points)_

Write another test for an empty RingBuffer. 

### Instructions

- The test case should provoke an exception. Make sure the expected exception is actually thrown and check the exception type, message, etc. 

### Submission

When you're done...

- [x] push your changes to your upstream repository on GitHub.
- [x] on GitHub, [create a release][GitHub creating releases] with version `v0.2`.
- [x] upload the [link to your release][GitHub linking to releases] on the e-learning platform until the specified date and time before the next lecture.
- [x] Only complete submissions adhering to all of the above requirements are considered. Late submissions, submissions via email or submissions failing to meet the specified requirements will not be accepted.


## Test all methods of RingBuffer _(3 points)_

Add additional tests to RingBufferTest. Make sure that all methods of the class RingBuffer are tested. 

### Instructions

- Every method of the class RingBuffer should be tested. However, you do not need to write a separate test method (e.g., `testFoo()`) for every RingBuffer method (e.g., `foo()`). Instead, consider typical usage scenarios of the class RingBuffer.
- Make sure to write meaningful, well-structured and readable test cases. 
- If you find a bug in the implementation of RingBuffer, demonstrate it by a failing (red) test. 

### Submission

When you're done...

- [x] push your changes to your upstream repository on GitHub.
- [x] on GitHub, [create a release][GitHub creating releases] with version `v0.3`.
- [x] upload the [link to your release][GitHub linking to releases] on the e-learning platform until the specified date and time before the next lecture.
- [x] Only complete submissions adhering to all of the above requirements are considered. Late submissions, submissions via email or submissions failing to meet the specified requirements will not be accepted.


## Fix any bugs in RingBuffer  _(2 points)_

Fix all bugs you found in the previous steps of the exercise in the class RingBuffer.

### Instructions

- In the previous steps, you wrote unit tests for all methods of the class RingBuffer. In case you found a bug, you demonstrated the erroroneus behaviour with a failing unit test.
- Now, fix all the bugs so that these failing test cases will pass.
- At the end, once all bugs are fixed, make sure that all your unit tests you wrote so far pass green. 

### Submission

When you're done...

- [x] push your changes to your upstream repository on GitHub.
- [x] on GitHub, [create a release][GitHub creating releases] with version `v0.3`.
- [x] upload the [link to your release][GitHub linking to releases] on the e-learning platform until the specified date and time before the next lecture.
- [x] Only complete submissions adhering to all of the above requirements are considered. Late submissions, submissions via email or submissions failing to meet the specified requirements will not be accepted.


## Add method setCapacity() to RingBuffer _(2 points)_

Add an additional method `setCapacity(int newCapacity)` to the class RingBuffer. Implement and test this new method. 

### Instructions

- Before you start extending the class RingBuffer with the new method, make sure all your existing unit tests run green.
- Add the method `setCapacity(int newCapacity)`, which allows to increase or decrease the capacity of a RingBuffer instance. 
- Add a JavaDoc comment describing the intended behavior and all aspects of the method interface.
- Consider the different cases that can occur when the capacity is increased or decreased on a RingBuffer instance that already contains elements. Make sure, that no elements are lost when the capacity changes.
- The method `setCapacity(int newCapacity)` should throw an exception if changing the capacity to newCapacity is not possible.
- Provide a unit test for all different cases including the exception cases to demonstrate how your implementation of `setCapacity(int newCapacity)` works.

### Submission

When you're done...

- [x] push your changes to your upstream repository on GitHub.
- [x] on GitHub, [create a release][GitHub creating releases] with version `v0.3`.
- [x] upload the [link to your release][GitHub linking to releases] on the e-learning platform until the specified date and time before the next lecture.
- [x] Only complete submissions adhering to all of the above requirements are considered. Late submissions, submissions via email or submissions failing to meet the specified requirements will not be accepted.




[GitHub creating releases]: https://help.github.com/articles/creating-releases/
[GitHub linking to releases]: https://help.github.com/articles/linking-to-releases/
