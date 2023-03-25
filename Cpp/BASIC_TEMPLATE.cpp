#include <bits/stdc++.h>

using namespace std;

typedef long long int ll;

#define test(t)     int t; cin >> t; while(t--)
#define f(i, a, b)  for(int (i) = (a); (i) < (b); ++(i))
#define endl        "\n"
#define deb(x)      cout << #x << ": " << x << endl;
#define fast        ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

// you code in this method
void solve() {
    cout << "Hello world" << endl;
}

int main() {
    fast;
    //Reads from file instead of you have to manually paste the data everytime
    ifstream infile(R"(C:\Users\Fahim\Unity\GameSwitch\docfx_project\src\Junior-Training-Sheet\Cpp\test.txt)");
    if (infile.good()) {
        cin.rdbuf(infile.rdbuf());
    }
    //Runs a loop t times
    //Like if input is 5 on first line it would call solve 5 times and print "Hello world" 5x;
    test(t) {
        solve();
    }
    return 0;
}