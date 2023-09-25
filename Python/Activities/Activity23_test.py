import pytest


# @pytest.fixture
# def num_list():
#     numlist = list(range(11))
#
#     return numlist

def test_sum(num_list):
    totsum = 0

    for n in num_list:
        totsum += n

    assert totsum == 55
