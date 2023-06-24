#include<bits/stdc++.h>
#include<boost/multiprecision/cpp_int.hpp>

namespace mp=boost::multiprecision;
using namespace mp;
using namespace std;


const int mod=1000000007;
int powa(int a,cpp_int b){
	long long x=1,y=a;
	while(b){
		if(b&1)x=x*y;
		if(x>=mod)x=x-(x/mod)*mod;
		y=y*y;
		if(y>=mod)y=y-(y/mod)*mod;
		b>>=1;
	}
	return x;
}
int main(){
	int t;
	cpp_int n,k;
	long long ans,z;
	while(t--){
		cin>>n>>k;
		k--;
		if(k>=mod)k%=mod;
		
		ans=(long long)(k);
		z = powa((int)(k),n);
		
		if(n&1)ans=(z-ans+mod)%mod;
		else ans = (z+ans+mod)%mod;
		
		printf("%lld\n",ans);
	}
} 

#include<bits/stdc++.h>
#include<boost/multiprecision/cpp_int.hpp>
using namespace boost::multiprecision;
using namespace std;
const int modulo=1000000007;

cpp_int powa(cpp_int x, cpp_int y){
    cpp_int result = 1;
    while(1){
		//x y = 2 
        if(y&1) result = (x*result)%modulo;
        y>>=1;
        if(!y) break;
        x = (x*x)%modulo;
    }
    return result;
}

int main()
{
    int t;
    cpp_int n, k, res;
    scanf("%d", &t);
    while(t--){
        cin>>n>>k;
        if(n&1) res = powa((k-1), n)-(k-1);
		//powa (2,2)-(2)
        else res = powa((k-1), n)+(k-1);
        cout << (res+modulo)%modulo << endl;
    }
    return 0;
}


#include<bits/stdc++.h>
#include<boost/multiprecision/cpp_int.hpp>
using namespace boost::multiprecision;
using namespace std;
#define mod 1000000007
 
cpp_int calc(cpp_int x, cpp_int y){
    // calc function has constructor that x is (k-1) or ans1 and y is n (section)
    cpp_int ans3 = 1;
    //declare ans3 = 1 to make a parameter
    while(1){
		//x y = 2 2 =>  3-1 color 2 section
		//x y = 2 3 =>  3-1 color 3 section
        if(y&1) {
			ans3 = (x*ans3)%mod;
		}
        y>>=1;
		// y /= 2
        if(!y) break;
        x = (x*x)%mod;
    }
    return ans3;
}
 
int main()
{
    int t;
    // using multiprecision library to expand the number beyond max data type of c++
    cpp_int n, k,ans1,ans2,ans3;
    //Input user total test case number
    cin >> t;
    //Make a while operation until t is zero
    while(t--){
        //input n and k variable
        cin>>n>>k;
        // understanding that the formula that F(n,k) = (k-1)^n +/- (-1)^n (k -1)
        // make k-1 into ans to make it simple
        ans1 = (long long)k-1; 
        // make (k-1)^2 into ans2 using function calc
        ans2 = calc(ans1,n); 
        // understandng that if n is odd, then using - operation. But if 
        // n is even, then using + operation
        if(n&1) ans3 = ans2-ans1;
        else ans3 = ans2+ans1;
        // print the result 
        cout << (ans3+mod)%mod << endl;
    }
    return 0;
}

#include<bits/stdc++.h>
#include<boost/multiprecision/cpp_int.hpp>
using namespace boost::multiprecision;
using namespace std;
#define mod 1000000007
 
cpp_int calc(cpp_int x, cpp_int y){
    // calc function has constructor that x is (k-1) or ans1 and y is n (section)
    cpp_int ans3 = 1;
    //declare ans3 = 1 to make a parameter
    while(1){
		//x y = 2 2 =>  3-1 color 2 section
		//x y = 2 3 =>  3-1 color 3 section
        if(y&1) {
			ans3 = (x*ans3)%mod;
		}
        y>>=1;
		// y /= 2
        if(!y) break;
        x = (x*x)%mod;
    }
    return ans3;
}
 
int main()
{
    int t;
    // using multiprecision library to expand the number beyond max data type of c++
    cpp_int n, k,ans1,ans2,ans3;
    //Input user total test case number
    cin >> t;
    //Make a while operation until t is zero
    while(t--){
        //input n and k variable
        cin>>n>>k;
        // understanding that the formula that F(n,k) = (k-1)^n +/- (-1)^n (k -1)
        // make k-1 into ans to make it simple
        ans1 = (long long)k-1; 
        // make (k-1)^2 into ans2 using function calc
        ans2 = calc(ans1,n); 
        // understandng that if n is odd, then using - operation. But if 
        // n is even, then using + operation
        if(n&1) ans3 = ans2-ans1;
        else ans3 = ans2+ans1;
        // print the result 
        cout << (ans3+mod)%mod << endl;
    }
    return 0;
}