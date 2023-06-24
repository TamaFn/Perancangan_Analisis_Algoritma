#include <iostream>
using namespace std;

// Deklarasikan modulo sebesar 10^9+7
const int MOD = 1000000007;

// Fungsi untuk menghitung nilai a^b % MOD
int power(int a, int b) {
    int result = 1;
    while (b > 0) {
        if (b & 1) {
            result = (1LL * result * a) % MOD;
        }
        a = (1LL * a * a) % MOD;
        b >>= 1;
    }
    return result;
}

int main() {
    int t;
    long long n, k;
    cin >> t;
    while (t--) {
        cin >> n >> k;

        // mengurangi k dengan 1 jika k >= MOD
        if (k >= MOD) {
            k %= MOD;
        }
        
        // menghitung nilai ans
        int ans = k;
        if (n & 1) {
            ans = (1LL * ans * -1 + MOD) % MOD;
        }

        // menghitung nilai a1 menggunakan fungsi power
        int a1 = power(k, n);

        // menampilkan hasil a1 + ans + MOD (untuk menjamin positif)
        cout << (a1 + ans + MOD) % MOD << "\n";
    }
    return 0;
}