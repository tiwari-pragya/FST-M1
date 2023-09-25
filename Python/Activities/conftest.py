import pytest

@pytest.fixture
def num_list():

    numlist = list(range(11))

    return numlist
