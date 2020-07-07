#include "stdint.h"
#include "C:/Keil/EE319KwareSpring2020/inc/tm4c123gh6pm.h"


void SystemInit(){};
 void uart_A(){
 
 
  uint32_t delay;
	 SYSCTL_RCGCUART_R|=0x01;
	 delay =1;// delay until get connect;
	SYSCTL_RCGCGPIO_R  |=0x21  ;
	delay =1;// delay until get connect;
	 
  GPIO_PORTA_AFSEL_R=0x03;//pb>>1(R)>>2(T)
	 GPIO_PORTA_PCTL_R=(( GPIO_PORTA_PCTL_R&0x0FFFFFF00)+0x11);//pa0&pa1//uart mode
	GPIO_PORTA_AMSEL_R&=~0x03;
	 
	 GPIO_PORTF_AFSEL_R=0;
	 GPIO_PORTF_PCTL_R=0;
	GPIO_PORTF_AMSEL_R=0;





	 
 GPIO_PORTA_LOCK_R=0x4C4F434B;
	GPIO_PORTA_CR_R=0x03;
	GPIO_PORTF_LOCK_R=0x4C4F434B;
	GPIO_PORTF_CR_R=0xFF;
	 
		
	GPIO_PORTA_DEN_R=0x03;
 
 	GPIO_PORTF_DIR_R=0xFF;
	GPIO_PORTF_DEN_R=0xFF;
 
	 
	 
	 
	 
  
	 
	 UART0_CTL_R&=~(1<<0);//disable uart
   UART0_IBRD_R=8;
	 UART0_FBRD_R=44;
	 
	 UART0_LCRH_R=(0x03<<5);//en>>wlen,fen(16 element),stp>>1 _bit


 UART0_CC_R=0x0;


	 UART0_CTL_R=(1<<0)|(1<<8)|(1<<9);
 
 }
 
 int main(){
	uart_A();
	
	while(1){

		while((UART0_FR_R&0x20)!=0){}// polling
            
			UART0_DR_R=00001111;
		    //  GPIO_PORTF_DATA_R=UART0_DR_R;   
			
		while((UART0_FR_R&0x100)==1){}
         //GPIO_PORTF_DATA_R=0x0E;   
			GPIO_PORTF_DATA_R=UART0_DR_R;
		

	}
 }
 