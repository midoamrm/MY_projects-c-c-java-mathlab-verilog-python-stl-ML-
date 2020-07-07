
#include"stdint.h"
#include "C:/Keil/EE319KwareSpring2020/inc/tm4c123gh6pm.h"





  void SysTick_Handler(void){
	
	GPIO_PORTF_DATA_R=0;
	
	
	GPIO_PORTF_DATA_R^=2;
	
	
	
	
	
	}