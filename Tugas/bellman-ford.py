def longest_increasing_subsequence(sequence):
    n = len(sequence)
    # Initialize an array to store the length of the longest increasing subsequence ending at each index
    lis = [1] * n

    # Find the longest increasing subsequence
    for i in range(1, n):
        for j in range(i):
            if sequence[i] > sequence[j] and lis[i] < lis[j] + 1:
                lis[i] = lis[j] + 1

    # Find the index of the longest increasing subsequence
    max_length_index = 0
    for i in range(1, n):
        if lis[i] > lis[max_length_index]:
            max_length_index = i

    # Find the longest increasing subsequence using backtracking
    subsequence = [sequence[max_length_index]]
    length = lis[max_length_index] - 1
    for i in range(max_length_index - 1, -1, -1):
        if sequence[i] < sequence[max_length_index] and lis[i] == length:
            subsequence.insert(0, sequence[i])
            length -= 1
            max_length_index = i

    return subsequence


# Test the function
sequence = [3, 6, 2, 7, 4, 5, 8, 1]
result = longest_increasing_subsequence(sequence)
print(result)
