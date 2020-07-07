 #include "stdint.h"
#include "C:/Keil/EE319KwareSpring2020/inc/tm4c123gh6pm.h"


void SystemInit(){};

	

	
	
	
	
	
	// configraition 
void init(void){
 
	 uint32_t delay;
	SYSCTL_RCGCGPIO_R  |=0x21  ;
	delay =1;// delay until get connect;
	GPIO_PORTF_AFSEL_R=0;
	 GPIO_PORTF_PCTL_R=0;
	GPIO_PORTF_AMSEL_R=0;
	//lock& cr
	GPIO_PORTF_LOCK_R=0x4C4F434B;
	GPIO_PORTF_CR_R=0xFF;
	
	//
	GPIO_PORTF_DIR_R=0xFF;
	GPIO_PORTF_DEN_R=0xFF;

}

void int_timer(){

NVIC_ST_CTRL_R=0;
NVIC_ST_RELOAD_R=0x00FFFF;
NVIC_ST_CURRENT_R=0;
	NVIC_ST_CTRL_R=0x00000005;







}




int  timer_I(uint32_t d){



NVIC_ST_RELOAD_R=d;

NVIC_ST_CURRENT_R=0;
	

	
	while(	(NVIC_ST_CTRL_R&0x00010000)==0){}
	
	
		return 0;
		
}



void chek(){




int count=0;
	int l=0;
	while(l<9){
	   GPIO_PORTF_DATA_R=count<<1;	
		
		count=(count+1)%8;
		int i;
		for(i=0;i<300;i++){
		
		
		timer_I(0x00FFFF);
			
			
		}
		
		
	l=l+1;
		
		
		

	}








}
	









int main(){
	init();
	int_timer();
		
	while(1){

		
		chek();// for timer counter from 0>8 in time=1/80*10^6 *2^23 *299=31.3 *__*
		
		
	
	}

}