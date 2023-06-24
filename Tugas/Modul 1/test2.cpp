#include <iostream>
#include <iomanip>
#include <cmath>

using namespace std;

#include <iostream>
#include <iomanip>
#include <cmath>

using namespace std;

int main(){
    // Declare variable of height (t), width(w), 
    double h,w,t;
    //Use EOF that while operation
    while(scanf("%lf %lf %lf",&h,&w,&t) != EOF){ 
        if(h == 0) return 0;
        double ans = (((pow(t,2))-1) * (pow(w,2)) / (16*h));
        cout << fixed << setprecision(3) << ans << endl;
    }
    
    return 0;
}