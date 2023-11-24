# Specification-Based Testing

The objective of this exercise is to apply of techniques for specification-based testing to design test cases.

## Equivalence Partitioning and Boundary Value Analysis _(2 points)_

Equivalence partitioning is a simple black-box test design technique. It is widely used to select test values from the range of all possible values that an input parameter or field can take by splitting the possible values into groups ("partitions") that produce equivalent results. Boundary value analysis as an extension suggests selecting values at the edges of these partitions for testing. In this exercise, you should achieve following goals:
* Apply equivalence partitioning on the parameter of the constructor of the class RingBuffer(int capacity).
* Find the boundary values for the identified equivalence partitions and use them in writing unit tests.

### Setup

Use the file _RingBufferCapacitySpec.txt_ as template for completing this part of the assignment. Create a folder _doc_ in your repository and add the specification file _RingBufferCapacitySpec.txt_ to this folder. 

### Instructions

* First, split the range of possible inputs to the parameter capacity of the constructor RingBuffer(int capacity) into valid and invalid partitions. 
  - Specify your results in the file _RingBufferCapacitySpec.txt_ in the assignment folder. Use the notation [from .. to] to specify each partition in terms of the range of all values between from and to including the values from and to. 
  - Annotate each partition with either "-> valid" or "-> invalid" to indicate the expected behavior.
  - Consider a partition to be invalid when the call to the constructor results in an exception to be thrown. Invalid partitions are equivalent if the same exception will be thrown.
  - The values to and from are the boundaries of your equivalence partitions. Use concrete values where possible or describe the relevant conditions for a boundary otherwise.
* Second, refine the partition of valid values into more fine-grained equivalence partitions. 
  - All input values belonging to the same valid partition should exhibit the same result, i.e., the instantiation of RingBuffer objects with equivalent behavior. 
  - Consider the behavior to be equivalent if you would draw the same state diagram to specify the RingBuffer object’s behavior. For example, a RingBuffer with capacity = 1 will only allow the two states EMPTY and FULL; see also assignment below.
  - Annotate each partition with a description of the expected result "-> expected result".
* Finally, implement unit tests as part of the new test class _RingBufferPartitionsTest.java_ exercising all boundary values of the valid and invalid equivalence partitions you identified in the two steps above. The test cases should assert the expected result or behavior you specified.

### Submission

When you're done...

- [x] create a folder _doc_ in your repository and add the specification file _RingBufferCapacitySpec.txt_ to this folder 
- [x] push your changes to your upstream repository on GitHub
- [x] on GitHub, [create a release][GitHub creating releases] shown as new version
- [x] finally, upload the [link to your release][GitHub linking to releases] on the e-learning platform until the specified date and time before the next lecture
- [x] Only complete submissions adhering to all of the above requirements are considered. Late submissions, submissions via email or submissions failing to meet the specified requirements will not be accepted.


## Designing State-based Tests for RingBuffer _(3 points)_

The hand-outs for the lecture contain a state diagram for a Stack and a receipt for systematically deriving test cases. Use the state diagram for Stack as a starting point and draw a similar state diagram for the RingBuffer (excluding the class RingBufferIterator). 

### Instructions

Derive test cases from this diagram according to the receipt in the lecture notes and implement these test cases using JUnit. 

**Note:** The states and transitions of the RingBuffer depend on the buffer's capacity. Basically, you could draw a different variant of the state diagram for each of the equivalence partitions defined in the previous part of the assignment. In this exercise, however, the goal is to combine all variants in one diagram. Annotate the transitions with corresponding guard conditions (expressed in square brackets "[...]") in the diagram.

* Start with sketching a state diagram for _RingBuffer_ (excluding _RingBufferIterator_). Add this diagram as _doc/StateDiagramRingBuffer.png_ to the repository.
  - Note: It is sufficient to only consider the methods _enqueue()_ and _dequeue()_ for chaning the state of the buffer.
* Design the test cases by drawing a _transition tree_ for the state diagram (_doc/TransitionTreeRingBuffer.png_). List all derived test cases in a text file (_RingBufferTests.txt_) like shown in the lecture notes.
* Create a JUnit test class _RingBufferStatesTest.java_. Implemented test cases should check (1) the state of the _RingBuffer_ after each transition and (2) any results returned by methods involved in the test sequence.

### Submission

When you're done...

- [x] push your changes to your upstream repository on GitHub
- [x] on GitHub, [create a release][GitHub creating releases] shown as new version
- [x] finally, upload the [link to your release][GitHub linking to releases] on the e-learning platform until the specified date and time before the next lecture
- [x] Only complete submissions adhering to all of the above requirements are considered. Late submissions, submissions via email or submissions failing to meet the specified requirements will not be accepted.


## Partitions and Boundaries for setCapacity _(3 points)_

Often, the observable behavior of a method not only depends on its input parameters but also on the internal state of the object the method operates on. The corresponding member variables defining the internal state have to be treated like input parameters, e.g., for _setCapacity(n)_ the internal state defined by the _size_ of the buffer is a relevant parameter too.

Furthermore, parameters may depend on each other and the definition of equivalence partitions cannot be done independently for each parameter. For example, in case of _setCapacity(n)_ the outcome valid or invalid when calling the method is defined by the choice of _n_ in relation to _size_, i.e., how many elements are already in the buffer. Therefore, the equivalence partitioning has to consider both parameters at the same time.


### Instructions

* Draw a matrix showing the valid and invalid equivalence partitions for _setCapacity_ depending on the parameters _n_ and _size_. 
  - The parameters _n_ and _size_ should be the dimensions of the matrix. Select small but appropriate value ranges for both parameters.  
  - The cells of the matrix should indicate the outcome in terms of valid or invalid response (i.e., exception thrown by setCapacity()). 
* Select representative values to cover all relevant equivalence partitions using corresponding boundary values.
* Implement unit tests as part of the test class _RingBufferPartitionsTest.java_ exercising all boundary values of the valid and invalid equivalence partitions you identified in the two steps above. The test cases should assert the expected result or behavior you specified.

### Submission

When you're done...

- [x] add the file containing the sketch of the matrix to the folder _doc_
- [x] push all your changes to your upstream repository on GitHub
- [x] on GitHub, [create a release][GitHub creating releases] shown as new version
- [x] finally, upload the [link to your release][GitHub linking to releases] on the e-learning platform until the specified date and time before the next lecture
- [x] Only complete submissions adhering to all of the above requirements are considered. Late submissions, submissions via email or submissions failing to meet the specified requirements will not be accepted.


## Additional Transitions in RingBuffer State-based Testing  _(2 points)_

The method _setCapacity_ also has an impact on the internal state of the RingBuffer, possibly leading to new transitions. The goal is to extend the state diagram created in the previous part of the assignment and to systematically derive test cases from the extended diagram. 

### Instructions

* Extend the state diagram for RingBuffer drawn above by adding the state transitions introduced by the method _setCapacity()_. 
  - Include calls to _setCapacity()_ that do not result in a change of the state. Show these transitions as back loops to the initial state in the state diagram.
  - Use guard conditions to distinguish different transitions from the same state wherever necessary.
  - Save this diagram as doc/ExtendedStateDiagramRingBuffer.png to the repository. 
* Design the test cases by using a transition tree for the extended state diagram. List all derived test cases in a text file (ExtendedRingBufferTests.txt).
* Create a JUnit test class ExtendedRingBufferStatesTest.java. Implemented test cases should check (1) the state of the RingBuffer after each transition and (2) any results returned by methods involved in the test sequence.

### Submission

When you're done...

- [x] push all your changes to your upstream repository on GitHub
- [x] on GitHub, [create a release][GitHub creating releases] shown as new version
- [x] finally, upload the [link to your release][GitHub linking to releases] on the e-learning platform until the specified date and time before the next lecture
- [x] Only complete submissions adhering to all of the above requirements are considered. Late submissions, submissions via email or submissions failing to meet the specified requirements will not be accepted.

[GitHub creating releases]: https://help.github.com/articles/creating-releases/
[GitHub linking to releases]: https://help.github.com/articles/linking-to-releases/
