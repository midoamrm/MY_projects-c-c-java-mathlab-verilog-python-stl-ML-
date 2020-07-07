#include <stdio.h>
#include <stdlib.h>
int res2(int m){

    return ((float)(m/10)/10+(m%10))*10;


}
int rse3(int h){


  return(((float)res2(h/10)/100)+(h%10))*100;



}



int main()
{
    int p;
    printf("please enter a number=");
    scanf("%d",&p);
    printf("%d",rse3(p));
    return 0;
}
