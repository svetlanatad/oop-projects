**Term/Year:** Fall 2022

**Subject Code and Course Number**: CS120 Intro to OOP, Sections B & D

**University and Faculty:** American University of Armenia, CSE

**Instructor name**:  Monika Stepanyan

**Mathematical Functions with Java**: Maths is Java or Java is Maths ? 


**Description**: The purpose of this is to create a hierarchy representing common mathematical functions. Refer to  diagram.png that shows all the classes that you will need to create, and the parent-child relationship between them.

**Function**: This is an abstract class Function that represents the notion of a mathematical function, f(x). My class includes methods with the following headings:
       // Returns the value of the function for a given input.
       public abstract double value(double input)
       // Returns the derivative of the function.
       public abstract Function derivative()
       // Scales the function by a given scalar.
       public abstract void scale(double scalar)
       // Returns the quotient of this function and another function.
       public Function divide(Function that)
       // Returns the difference of this function and another function.
       public Function subtract(Function that)
       // Returns the sum of this function and another function.
       public Function add(Function that)
       // Returns the product of this function and another function.
       public Function multiply(Function that)
       // Returns the square of the function.
       public Function square()
       // Returns a copy of a given function.
public static Function copy(Function that) 1

**Note that at the moment any of these methods aren't implemented, instead, default implementations are provided. 

**SimpleFunction**: This is an abstract class SimpleFunction that inherits from Function and represents a category of simple functions.
The class also includes the following overloaded methods:
       public abstract Function add(SimpleFunction that)
       public abstract Function multiply(SimpleFunction that)
       public abstract Function subtract(SimpleFunction that)
Two classes will fall under this category– Constant and Polynomial functions. Polynomials and constants are both closed under multiplication and summation/subtraction;
• multiplying two polynomials results in a polynomial,
• adding/subtracting two polynomials results in a polynomial, • multiplying two constants results in a constant,
• adding/subtracting two constants results in a constant,
Moreover, both the sum/difference and the product of two functions f(x) and g(x) s.t. one is a constant and the other one is a polynomial will give us a polynomial. Therefore, these two classes will provide additional functionality for summation/subtraction and multiplication in the case when the argument is of SimpleFunction type.


**CompositeFunction**: This is an abstract class CompositeFunction that inherits from Function and represents a category of composite functions of the form c * f (g(x)):
• c is a constant value
• f is the “outer” function
• g is the “inner/argument” function
As an example, consider 4.7 ∗ sin(log(x2 + 1)): f is sin, g is log and c is 4.7. Note that in this particular example, g also represents a composite function.
The class includes two attributes– the constant value and the inner function. The class also includes:
• accessors for all instance variables
• a two-argument constructor (note that you need to use copy() method here (even though it currently doesn’t have an appropriate implementation) to avoid privacy leaks)
• an overridden method scale()
• an overridden method equals()

**TrigonometricFunction**: This is an abstract class TrigonometricFunction that inherits from CompositeFunction and represents a category of trigonometric functions. The class includes a constructor matching the super constructor and an overridden method equals().

**Note**: You can find files Test.java and example.txt attached in the assignment description. The first includes a main method for testing some functionalities of the hierarchy, and the second contains the resulting outputs.

**ComplexFunction**: The  class ComplexFunction inherits from Function and represents a category of complex functions. We define complex function as a
• sum of two functions f (x) + g(x)
• difference of two functions f (x) − g(x)
• product of two functions f (x) ∗ g(x)
• quotient of two functions f(x) g(x)
The class definition includes enum Type that describes the type of the complex function (“SUM”, “DIFFERENCE”, “PRODUCT”, “QUOTIENT”).
The class includes three instance variables– Type type, Function f and Function g. The class also includes:
• a three-argument constructor
• a copy constructor
• an overridden method scale() that uses a switch on the type to determine how the function should be modified
• an overridden method value() that uses a switch on the type to determine what value should be returned
• an overridden method derivative() that uses a switch on the type to determine what function should be returned. Please be mindful of the derivation rules :) 
• an overridden method toString() that uses a switch on the type to construct and return a
string representing this function. This uses the following formatting for each of the cases: 
(a) (f(x))+(g(x))
(b) (f(x))−(g(x))
(c) (f(x))∗(g(x))
(d) (f(x))/(g(x))
Note that method toString() is available to any Function and will be overridden in all other
concrete classes in the hierarchy.

In class Function now we provide implementations for methods divide,
subtract, add, multiply, square().
Inside method copy(that) I added code that would return a new instance of ComplexFunction constructed through a copy-constructor of class ComplexFunction (given that the argument is an instance of ComplexFunction class).

**Exponential**: The class Exponential inherits from CompositeFunction and represents an exponential function of the form c ∗ bg(x):
• c is a constant value • b is the base
• g is the exponent
The class should include an additional attribute representing the base value. The class should also include:
• a three-argument constructor that calls the super constructor with appropriate arguments
• a copy constructor
• an overridden method value()
• an overridden method derivative(). 
• an overridden method toString() that returns the string representation of this function using
the format c*b ̂{g(x)}
• an overridden method equals()

**Logarithm**:  The class Logarithm inherits from CompositeFunction and represents a logarithmic function of the form c ∗ logb g(x):
• c is a constant value • b is the base
• g is the argument
The class should include an additional attribute representing the base value. The class should also include:
• a three-argument constructor that calls the super constructor with appropriate arguments
• a copy constructor
• an overridden method value()
• an overridden method derivative(). Please be reminded of the following derivation rule:
(a) (c∗logb g(x))′ = c∗g′(x)∗ 1 = c∗g′(x) ln(b)∗g(x) ln(b)∗g(x)
• an overridden method toString() that returns the string representation of this function using the format c*log[b](g(x))
• an overridden method equals()
**Ln**: Create a class Ln that inherits from Logarithm and represents the natural
logarithm of the form c ∗ loge g(x) = c ∗ ln g(x) (e = 2.71 . . . ). The class should include:
• a three-argument constructor that calls the super constructor with appropriate arguments
• a copy constructor
• an overridden method toString() that modifies the value returned by super toString and returns the string representation of this function using the format c*ln(g(x))
• an overridden method equals()

**Sine** The class Sine inherits from TrigonometricFunction and represents a sine function of the form c ∗ sin(g(x))
The class includes:
• a two-argument constructor that calls the super constructor with appropriate arguments
• a copy constructor
• an overridden method value()
• an overridden method toString() that returns the string representation of this function using the format c*sin(g(x))
• an overridden method equals()
11. (Cosine | 5 points) Create a class Cosine that inherits from TrigonometricFunction and
represents a cosine function of the form c ∗ cos(g(x)) The class should include:
• a two-argument constructor that calls the super constructor with appropriate arguments
• a copy constructor
• an overridden method value()
• an overridden method derivative(). Please be reminded of the following derivation rule:
(a) (c ∗ cos(g(x)))′ = c ∗ g′(x) ∗ − sin(g(x)) = −c ∗ g′(x) ∗ sin(g(x))
• an overridden method toString() that returns the string representation of this function using
the format c*cos(g(x))
• an overridden method equals()
Now go back to Sine class and override the derivative() based on the following derivation rule: (a) (c ∗ sin(g(x)))′ = c ∗ g′(x) ∗ cos(g(x))
**Tan**: Create a class Tan that inherits from TrigonometricFunction and represents a tangent function of the form c * tan(g(x))
The class includes:
• a two-argument constructor that calls the super constructor with appropriate arguments
• a copy constructor
• an overridden method value()
• an overridden method derivative(). Please be reminded of the following derivation rule:
(a) (c ∗ tan(g(x)))′ = c ∗ g′(x) ∗ 1 = c∗g′(x) cos2 g(x) cos2 g(x)
• an overridden method toString() that returns the string representation of this function using the format c*tan(g(x))
• an overridden method equals()
**Cotan**: The class Cotan inherits from Tan and represents a cotangent function of the form c * cot(g(x)) (same as c )
The class includes:
• a two-argument constructor that calls the super constructor with appropriate arguments
• a copy constructor
• an overridden method value() that uses the value returned by super
• an overridden method derivative(). Please be reminded of the following derivation rule:
(a) (c∗cot(g(x)))′ =c∗g′(x)∗− 1 =− c∗g′(x) sin2 g(x) sin2 g(x)
• an overridden method toString() that returns the string representation of this function using the format c*cot(g(x))
• an overridden method equals()

**Constant**: The class Constant inherits from SimpleFunction and represents a constant function of the form f(x) = c. The class includes an attribute representing the constant value. The class also includes:
• a one-argument constructor
• a copy constructor
• an overridden method value(...) that returns the value of this function
• an overloaded method value() that returns the constant value
• an overridden method derivative(). Please be reminded that c′ = 0.
• an overridden method scale()
• an overridden method add(SimpleFunction that) that returns a new function representing the sum of this and that functions. Note that that should be either of type Constant or Polynomial. In addition, note that while you haven’t defined class Polynomial yet, you won’t be able to complete this method
• an overridden method subtract(SimpleFunction that) that returns a new function repre- senting the difference of this and that functions. Your implementation can rely on add()
• an overridden method multiply(SimpleFunction that) that returns a new function repre- senting the product of this and that functions. Again, you should return to this method after implementing the Polynomial class
• an overridden method square() that returns square of this function
• an overloaded method divide(ConstantFunction) that returns a new constant function
representing the ratio of this and that functions.
• an overridden method toString() that returns the string representation of this function
• an overridden method equals()
**Polynomial**: The class Polynomial inherits from SimpleFunction and represents a polynomial function of degree d of the form f(x) = cd ∗xd +cd−1 ∗xd−1 +· · ·+c1 ∗x+c0 where cis are any real numbers.
The class includes three instance variables – the degree, an array of coefficients [cd, cd−1, . . . , c1] and a Constant function representing the last (c0) term.
The class also includes:
• a constructor that takes as an argument an array of double values and initializes all the instance variables
• a copy constructor
• an overridden method value() that returns the value of this function
• an overridden method derivative(). Please be reminded that
(cd ∗xd +cd−1 ∗xd−1 +···+c1 ∗x+c0)′ =d∗cd ∗xd−1 +(d−1)∗cd−1 ∗xd−2 +···+c1.
• an overridden method scale()
• an overridden method add(SimpleFunction that) that returns a new function representing the sum of this and that functions. Note that that should be either of type Constant or Polynomial.
• an overridden method subtract(SimpleFunction that) that returns a new function repre- senting the difference of this and that functions. Your implementation can rely on add()
• an overridden method multiply(SimpleFunction that) that returns a new function representing the product of this and that functions.
• an overridden method square() that returns square of this function.
• an overridden method toString() that returns the string representation of this function using the format cd ∗xd +cd−1 ∗xd−1 +···+c1 ∗x+c0. If a coefficient ci is equal to 0, do not include the corresponding term.
• an overridden method equals()
