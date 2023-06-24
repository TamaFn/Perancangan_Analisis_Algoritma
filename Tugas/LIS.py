# Global variable to store the LIS sequence
global lis_sequence


def _lis(arr, n):
    # To allow access to the global variable
    global lis_sequence

    # Base Case
    if n == 1:
        return [arr[0]]

    # lisEndingHere is the LIS ending with arr[n-1]
    lisEndingHere = [arr[n-1]]

    # Recursively get all LIS ending with arr[0], arr[1]..arr[n-2]
    for i in range(1, n):
        res = _lis(arr, i)
        if arr[i-1] < arr[n-1] and len(res) + 1 > len(lisEndingHere):
            lisEndingHere = res + [arr[n-1]]

    # Compare lisEndingHere with the overall LIS sequence
    if len(lisEndingHere) > len(lis_sequence):
        lis_sequence = lisEndingHere

    return lisEndingHere


def lis(arr):
    # To allow access to the global variable
    global lis_sequence

    # Length of arr
    n = len(arr)

    # Initialize the LIS sequence with the first element
    lis_sequence = [arr[0]]

    # The function _lis() stores its result in lis_sequence
    _lis(arr, n)

    return lis_sequence


# Driver program to test the above function
if __name__ == '__main__':
    arr = [10, 22, 9, 33, 21, 50, 41, 60]
    n = len(arr)

    # Function call
    lis_seq = lis(arr)
    print("Longest Increasing Subsequence:", lis_seq)
    print ("Length of lis is", len(lis(arr)))
