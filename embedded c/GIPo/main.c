 #include "stdint.h"
#include "C:/Keil/EE319KwareSpring2020/inc/tm4c123gh6pm.h"
#include "GGPIO_int.h"

//#include "tm4c123gh6pm.h"

void SystemInit(){};
	void delay(int  g){
		
		int i,k;
	for(i=0;i<g;i=i+1)
	{
		for(k=0;k<1000;k++)
		{
	  } 
	
	}
		
		
		
	}
	
	
	
	
	
void lcd_command(char comm){
	
GPIO_PORTA_DATA_R=0;//conrtro confgier EN=0
	
		GPIO_PORTF_DATA_R=comm;//data send
		GPIO_PORTA_DATA_R|=0x80;// EN=1
delay(2000);		//latch
	
	GPIO_PORTA_DATA_R=0;// EN=0
	
	
	GPIO_setPortValue(Port_A,0);
	GPIO_setPortValue(Port_F,comm);
	GPIO_setPortValue(Port_A,0X80);
	   delay(2000);
	 
	GPIO_setPortValue(Port_A,0);

	}
	
	void  lcd_data(char data){
	

GPIO_PORTA_DATA_R=0x20;//conrtro confgier EN=0
		GPIO_PORTF_DATA_R=data;//data send
		GPIO_PORTA_DATA_R|=0x80;// EN=1
delay(20000);		//latch
	
	GPIO_PORTA_DATA_R&=0xDF;// EN=0

		
		
		GPIO_setPortValue(Port_A,0x20);
		GPIO_setPortValue(Port_F,data);
		GPIO_setPortValue(Port_A,0);
		delay(200);
		GPIO_setPortValue(Port_A,0);
		
		


	}
	
	
	
	// configraition 
void init(void){
 // F>>data
	//a>>command
	 uint32_t delay;
	SYSCTL_RCGCGPIO_R  |=0x21  ;
	delay =1;// delay until get connect;
	GPIO_PORTF_AFSEL_R=0;
	 GPIO_PORTF_PCTL_R=0;
	GPIO_PORTF_AMSEL_R=0;
	//lock& cr
	GPIO_PORTF_LOCK_R=0x4C4F434B;
	GPIO_PORTF_CR_R=0xFF;
	GPIO_PORTA_LOCK_R=0x4C4F434B;
	GPIO_PORTA_CR_R=0xFF;
	//
	GPIO_PORTF_DIR_R=0xFF;
	GPIO_PORTF_DEN_R=0xFF;
//GPIO_PORTF_PUR_R=0x11;
	//
	GPIO_PORTA_DIR_R=0xE0;
	GPIO_PORTA_DEN_R=0xE0;
	//GPIO_PORTF_PUR_R=0x11;
	// wakeup
lcd_command(0x30);

	//2 line(d0.d7)
  lcd_command(0x38);//100
	//shift rigth
	lcd_command(0x06);//110
	//clear
	lcd_command(0x01);//000
	//desplayon
	lcd_command(0x0F);//111


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











int main(){
	init();
	
	while(1){

		
  
		lcd_command(0x01);//000
		lcd_command(0x80);//000
		lcd_data(0x0F);//111
		lcd_command(0x082);//001
    lcd_data(0x06);//		011

		
		
	
	}

}