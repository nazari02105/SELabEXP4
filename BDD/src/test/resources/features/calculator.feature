@tag
Feature: Calculator
  Scenario: add two numbers
    Given Two input values, 1 and 2
    When I add the two values
    Then I expect the result 3

  Scenario Outline: add two numbers
    Given Two input values, <first> and <second>
    When I add the two values
    Then I expect the result <result>
    Examples:
      | first | second | result |
      | 1 | 12 | 13 |
      | -1 | 6 | 5 |
      | 2 | 2 | 4 |

  Scenario: divide two numbers
    Given Two input values, 4 and 2
    When I divide the two values
    Then The result should be 2.0

  Scenario Outline: divide two numbers
    Given Two input values, <first> and <second>
    When I divide the two values
    Then The result should be <result>
    Examples:
      | first | second | result |
      | 5 | 2 | 2.5 |
      | 50 | 2 | 25 |
      | 7 | 3 | 2.333 |

  Scenario: square root a number
    Given One input value, 4
    When I calculate the square root of the number
    Then The result should be 2.0

  Scenario Outline: square root a number
    Given One input value, <first>
    When I calculate the square root of the number
    Then The result should be <result>
    Examples:
      | first | result |
      | 5 | 2.236 |
      | 25 | 5 |
      | 144 | 12 |

  Scenario: square root of division of two numbers
    Given Two input values, 4 and 2
    When I calculate the square root of the division of two numbers
    Then The result should be 1.414

  Scenario Outline: square root of division of two numbers
    Given Two input values, <first> and <second>
    When I calculate the square root of the division of two numbers
    Then The result should be <result>
    Examples:
      | first | second | result |
      | 4 | 1 | 2 |
      | 36 | 4 | 3 |
      | 17 | 5 | 1.843 |
