#include "stdint.h"
#include "C:/Keil/EE319KwareSpring2020/inc/tm4c123gh6pm.h"
#include  "GPIO_int.h"
#include  "KPD_Int .h"

#include <string.h> // to use strcmp() functiom


#define BIT_IS_SET(REG,BIT) ( REG & (1<<BIT) ) // use to defin set bit number 
	
	#define BIT_IS_CLEAR(REG,BIT) ( !(REG & (1<<BIT)) ) // use to defin clear bit number 


void SystemInit(){};
	

	char *ROOMNUM[8]; //  set up here room number 9 room
	
	
 	//free is mean chickout
	// Occupied is mean chickin
	// Room_Cleaning is mean  Room want to Clean
	char *passcode_keypade=""; //used to  set in passcod enter from keypad
	
	
	u8 room(char*passcode,char *status){ // function used to handling the room statues 
   u8 currnt=0;
    // 0-lock
		//1->unlock
			char *strg1="Occupied";
	   char *strg2="free";
		 char *strg3="RoomCleaning";
			
		if(strcmp( status,  strg1)==0){ // check state "Occupied"
		  if( strcmp( passcode,passcode_keypade )==0 ){ // check passcode with passcode guest entr on keypad
			
			currnt=0xFF;//open  door
				
				return currnt;
			}
		 }
			if(strcmp( status,  strg2)==0){// check state "free"
			
				currnt=0; //loced door
				 return currnt;
				
			}
				if(strcmp( status,  strg3)==0){ // check state "cleaning"
				
				
				currnt=0xFF; //unloced door
				 return currnt;
				}
		
		currnt=0x00;
			
			return currnt;
			}

void UART_Send_Char(char character){ // function used to  get one char
	while(BIT_IS_SET(UART0_FR_R,5)){};UART0_DR_R=character; // here is polling  on FR rigster flag untill get
		//one in bit 5 to set data-> char in UART0_DR_R
	
}
	
	
char UART_Receive_Char(){  // function used to  set one char
	char data;
		 while(BIT_IS_SET(UART0_FR_R,4)){};data=UART0_DR_R;// here is polling  on FR rigster flag untill get
		//one in bit 4 to get data-> char from UART0_DR_R
	
return data;
}

void UART_Send_String(const char *Str ) 
{
	u8 i = 0;
	while(Str[i] != '\0') 
	{
		UART_Send_Char(Str[i]); // pass char to UART_Send_Char()  from array of char str
		i++;
	}
}
void UART_Receive_String(char *Str)
{
	
	u8 i = 0;                           
	Str[i] = UART_Receive_Char();
	while(Str[i] != '#')
	{
		i++;
		Str[i] = UART_Receive_Char(); // get char from UART_Receive_Char()  and store it in array of char str
	}
	Str[i] = '\0';
}



	
 void uart_A(){ //port_Aand port_f is inzilti
   /// first Initialize the UART0 module///
 
  uint32_t delay; // dummy varible
	 SYSCTL_RCGCUART_R|=0x01; // enable clock for uart0
	 delay =1;// delay until get connect;
	SYSCTL_RCGCGPIO_R  |=0xFF  ;// enable clock for Port A,B,C,D,F
	delay =1;// delay until get connect;
	 GPIO_init(Port_B);	 // Initialize for use to send 1 Or 0 for senloid is explain in gpio driver
	  GPIO_init(Port_D);
	  GPIO_init(Port_C);
  GPIO_PORTA_AFSEL_R=0x03;// enable alternate functions on PA1-0
	 GPIO_PORTA_PCTL_R=(( GPIO_PORTA_PCTL_R&0x0FFFFFF00)+0x11);// configure PA1-0 as UART0	
	GPIO_PORTA_AMSEL_R&=~0x03; // to ensure that not anloge mode
	 
	 GPIO_PORTF_AFSEL_R=0; // not needed  alternate functions as used as gpio
	 GPIO_PORTF_PCTL_R=0;
	GPIO_PORTF_AMSEL_R=0;





	 
 GPIO_PORTA_LOCK_R=0x4C4F434B ; // used to unlock port F and (A may not needed) to can read or write
	GPIO_PORTA_CR_R=0x03;
	GPIO_PORTF_LOCK_R=0x4C4F434B;
	GPIO_PORTF_CR_R=0xFF;
	 
		
	GPIO_PORTA_DEN_R=0x03; // enable digital I/O on PA1-0
 
 	GPIO_PORTF_DIR_R=0xFF;
	GPIO_PORTF_DEN_R=0xFF;// enable digital I/O on PF
 
	 
	 
	 
	 // configer uart0
  
	// BRD = 80,000,000 / (16*9600) = 520.8333333
	// UARTFBRD[DIVFRAC] = integer(0.8333333 * 64 + 0.5) = 53
	 
	 UART0_CTL_R&=~(1<<0);//disable uart
   UART0_IBRD_R=520;
	 UART0_FBRD_R=53;
	 
	 UART0_LCRH_R=(0x03<<5);// // 8 bit data, no parity bits, 1 stop bit


 UART0_CC_R=0x0; // Configure the UART clock source by writing to the UARTCC register.
	


	 UART0_CTL_R=(1<<0)|(1<<8)|(1<<9); // (bit 0: enable uart) (bit 8: enable Tx) (bit 9: enable Rx)
 
 }
 
 int main(){
	 u8 kpd_sc[3][4];
	uart_A(); //  Initialize and configer uart0
		int cont=0;
	 // setup mode entering number of room
	 UART_Receive_String( ROOMNUM[0]);//100#200#*#  in which (100#) string and (200#) anther  string
	 
	 u8 h=0;                          ///if he want to end setup mode he must enter* fllowed by # string
                                   /// every string is enter must fllowed by # to end string he enter and to enter
                                   // enter new string	 
	 
	 
	 while(strcmp( ROOMNUM[h], "*")&&h<9){
	 
	     h++;
		  UART_Receive_String( ROOMNUM[h]);
		 }
	 //// end setup as  is entre nubmber of room once 
	while(1){
   
		
		char* status;
		 char* status_check;
		char* passcode;
		char*roomnum;
		
		/*passcode_keypade="1";
		  status="Occupied";
		  status_check=status;
		 passcode="1" ;      //for simulation
		 roomnum="1";
		ROOMNUM[0]="1";	
	ROOMNUM[1]="2";
	*/	
	// uart---input   
		                                 
		                                
		
		UART_Receive_String(status);
		UART_Receive_String(roomnum);
		 status_check=status;
			if(strcmp( status_check, "Occupied" )==0){ // this we set the paasscode only vistor want to check in
		
		UART_Receive_String( passcode);
	}
		
		if(strcmp( status_check, "Occupied" )==0){ // here guest need to entre passcode on keypad only if status "Occupied"
		//keypad function set_in 
			 if(strcmp( roomnum, ROOMNUM[0])==0){
	    passcode_keypade=KPD_getPassword(kpd_sc,Port_D);
				 // keypad connceted to portD 
			 }
			 if(strcmp( roomnum, ROOMNUM[1])==0){
	    passcode_keypade=KPD_getPassword(kpd_sc,Port_C);
				 // here i must  change  from connceted  keypad portD to anther port as each room have its keypad and so its port
			 }
		// here i can add many if to check room nuber and many  keypads with many ports according to max room number
		}
		// here is put high (one) on selnoid_door from port b from PB0 toPB7
		if(strcmp( roomnum, ROOMNUM[0])==0){
		//GPIO_PORTF_DATA_R= (0x02)&(room(passcode, status)); //for simulation
			GPIO_PORTB_DATA_R=(0x01)&(room(passcode, status));//// PB0 is high egule 1 to open selnoid_Door for room_1
			 }
		// portf indecating to seaenoid
		 if(strcmp( roomnum, ROOMNUM[1])==0){
		//	GPIO_PORTF_DATA_R= (0x04)&(room(passcode, status)); //for simulation
		GPIO_PORTB_DATA_R=(0x02)&(room(passcode, status));// PB1 is high egule 1 to open selnoid_Door for room_2
			 }
		//and so on  i can add many if to check room nuber to open boor  according to max room number
		}
 }
 