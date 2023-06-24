#include <iostream>
#include <iomanip>
#include <cmath>

using namespace std;

#include <iostream>
#include <iomanip>
#include <cmath>

using namespace std;

int main(){
    // Declare variable of height (t), width(w), and t is heigh of the tunnel
    double h,w,t;
    //Use EOF that while operation still running from user input
    while(scanf("%lf %lf %lf",&h,&w,&t) != EOF){ 
        //return 0 value if height of the mountain is 0
        if(h == 0) return 0;
        //input the number into the formula 
        double ans = (((pow(t,2))-1) * (pow(w,2)) / (16*h));
        cout << fixed << setprecision(3) << ans << endl;
    }
    
    return 0;
}