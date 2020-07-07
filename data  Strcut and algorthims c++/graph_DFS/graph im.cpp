
#include <iostream>

#include<vector>

using namespace std;
template<class T>

class graph{

	vector<T> *adj;
	int vertices = 0; int edge = 0;
	
public:
	graph(int ver,int ed) {
		vertices = ver;
		edge = ed;
		adj = new vector<T>[ver];
		
	}

	void addedge(T u,T v) {

		adj[u].push_back(v);
		adj[v].push_back(u);
	}



	void printgrap() {
		for(int i=0;i<vertices;i++){
			cout << i;
			for (auto it : adj[i]) {
				cout << "->" << it;
			}

			cout << "\n";
		}
		
		}

	void dfs_helper(int s, bool* visted)
	{
		cout << "Visted :" << s<<endl;
		visted[s] = true;
		for (auto it : adj[s]) {
		
			if (!visted[it]) {

				cout << "GOing to Vertcix: " << it << "From Vertcix:" << s<<endl;

				dfs_helper(it, visted);

			}




		}

		



		
		




	}

	void dfs_ru(int s) {
	     
		bool *visted = new bool[vertices];

		for (int i = 0; i < vertices; i++) {
			visted[i]=false;


		}

		dfs_helper(s, visted);
			
	}








	~graph() {

		delete[] adj;
		


	}


	


};






int main()
{
	int n, m;
	int u, v;
	cin >> n;
	cin >> m;
	graph<int> g (n, m) ;
	for (int i = 0; i < m; i++) {

		cin >> u;
		cin >> v;
		g.addedge(u, v);


	}

	g.printgrap();
	g.dfs_ru(5);
   
}
