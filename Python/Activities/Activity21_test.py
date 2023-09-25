import pytest


def test_addition():
    num1 = 20
    num2 = 10

    total = num1 + num2

    assert total == 30
    print("Sum is " + str(total))


def test_subtraction():
    num1 = 20
    num2 = 10

    diff = num1 - num2

    assert diff == 10
    print("Difference is " + str(diff))


def test_multiplication():
    num1 = 20
    num2 = 10

    prod = num1 * num2

    assert prod == 200
    print("Product is " + str(prod))


def test_division():
    num1 = 20
    num2 = 10

    quot = num1 / num2

    assert quot == 2
    print("Quotient is " + str(quot))
