#include "stdint.h"
#include "C:/Keil/EE319KwareSpring2020/inc/tm4c123gh6pm.h"
void SystemInit(){};

int main(){


	uint32_t delay;
	SYSCTL_RCGCGPIO_R  |=0x20  ;
	delay =1;// delay until get connect;
   GPIO_PORTF_DIR_R=0x0e;
	GPIO_PORTF_AFSEL_R &=~ 0x0E;
	GPIO_PORTF_DEN_R=0x0e;
	
	NVIC_ST_RELOAD_R=50-1;
	
	NVIC_ST_CTRL_R=7;
	__enable_irq();
//	EnableInterrupts();
	
    while(1){
		
//		  WaitForInterrupts();
	       GPIO_PORTF_DATA_R^=4;
		
		
		}







}