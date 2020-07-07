#include "KPD_Int .h"

u8 INPUT_Pin[no_Of_Rows]={Pin0 , Pin1 ,Pin2 , Pin3};
u8 OUTPUT_Pin[no_Of_Coloumns]={Pin4 , Pin5 ,Pin6};

void KPD_ScanKeys(u8 KPD_Array[no_Of_Coloumns][no_Of_Rows],u8 Port_KPD){

	u8 coloumn , row , setter;
	
	for(coloumn=0 ; coloumn < no_Of_Coloumns ; coloumn++){	//deh btlf 3la el coloumns

			for(setter=0 ; setter < no_Of_Coloumns ; setter++){	//deh btst el coloumn el enta feh el o/p value = 0

				if(setter==coloumn)	GPIO_setPinValue(Port_KPD ,OUTPUT_Pin[setter] ,LOW);
				else	GPIO_setPinValue(Port_KPD ,OUTPUT_Pin[setter] ,HIGH);
			}
			
			for(row=0 ; row < no_Of_Rows ; row++){	//deh el btgib el values bta3t el pin and save it in array
				
				u8 level;
				GPIO_getPinValue(Port_KPD ,INPUT_Pin[row],&level);
				KPD_Array[coloumn][row] = level;
			}
		}
}

short int KPD_getNumber(u8 KPD_Array[no_Of_Coloumns][no_Of_Rows]){

	if(KPD_Array[0][0]==0) return 1;

	if(KPD_Array[0][1]==0) return 2;

	if(KPD_Array[0][2]==0) return 3;

	if(KPD_Array[1][0]==0) return 4;

	if(KPD_Array[1][1]==0) return 5;

	if(KPD_Array[1][2]==0) return 6;

	if(KPD_Array[2][0]==0) return 7;

	if(KPD_Array[2][1]==0) return 8;

	if(KPD_Array[2][2]==0) return 9;
	
	if(KPD_Array[2][3]==0) return 0;
	
	return -1;
}

char* KPD_getPassword(u8 KPD_Array[no_Of_Coloumns][no_Of_Rows], u8 Port_KPD){

	u8 numberOfKPDInputs=0;
	short int value;
	char*enteredPassword;
	while(numberOfKPDInputs!=4){
			KPD_ScanKeys(KPD_Array, Port_KPD);
			value = KPD_getNumber(KPD_Array);
			if(value == -1)	//this means user doesn't press any button
				continue;
			enteredPassword[numberOfKPDInputs]=(char)value;
			numberOfKPDInputs++;
		}
	return enteredPassword;
}

/*

	KPD_ScanKeys(KPD_Array);

	if(KPD_Array[0][0]==0) DIO_setPinValue(Port_C ,Pin0 ,HIGH);
	else DIO_setPinValue(Port_C ,Pin0 ,LOW);

	if(KPD_Array[0][1]==0) DIO_setPinValue(Port_C ,Pin0 ,HIGH);
		else DIO_setPinValue(Port_C ,Pin0 ,LOW);

	if(KPD_Array[0][2]==0) DIO_setPinValue(Port_C ,Pin0 ,HIGH);
		else DIO_setPinValue(Port_C ,Pin0 ,LOW);

	if(KPD_Array[0][3]==0) DIO_setPinValue(Port_C ,Pin0 ,HIGH);
		else DIO_setPinValue(Port_C ,Pin0 ,LOW);


	if(KPD_Array[1][0]==0) DIO_setPinValue(Port_C ,Pin0 ,HIGH);
	else DIO_setPinValue(Port_C ,Pin0 ,LOW);

	if(KPD_Array[1][1]==0) DIO_setPinValue(Port_C ,Pin0 ,HIGH);
	else DIO_setPinValue(Port_C ,Pin0 ,LOW);

	if(KPD_Array[1][2]==0) DIO_setPinValue(Port_C ,Pin0 ,HIGH);
	else DIO_setPinValue(Port_C ,Pin0 ,LOW);

	if(KPD_Array[1][3]==0) DIO_setPinValue(Port_C ,Pin0 ,HIGH);
	else DIO_setPinValue(Port_C ,Pin0 ,LOW);

	if(KPD_Array[2][0]==0) DIO_setPinValue(Port_C ,Pin0 ,HIGH);
	else DIO_setPinValue(Port_C ,Pin0 ,LOW);

	if(KPD_Array[2][1]==0) DIO_setPinValue(Port_C ,Pin0 ,HIGH);
	else DIO_setPinValue(Port_C ,Pin0 ,LOW);

	if(KPD_Array[2][2]==0) DIO_setPinValue(Port_C ,Pin0 ,HIGH);
		else DIO_setPinValue(Port_C ,Pin0 ,LOW);

	if(KPD_Array[2][3]==0) DIO_setPinValue(Port_C ,Pin0 ,HIGH);
		else DIO_setPinValue(Port_C ,Pin0 ,LOW);

	if(KPD_Array[3][0]==0) DIO_setPinValue(Port_C ,Pin0 ,HIGH);
	else DIO_setPinValue(Port_C ,Pin0 ,LOW);

	if(KPD_Array[3][1]==0) DIO_setPinValue(Port_C ,Pin0 ,HIGH);
	else DIO_setPinValue(Port_C ,Pin0 ,LOW);

	if(KPD_Array[3][2]==0) DIO_setPinValue(Port_C ,Pin0 ,HIGH);
	else DIO_setPinValue(Port_C ,Pin0 ,LOW);

	if(KPD_Array[3][3]==0) DIO_setPinValue(Port_C ,Pin0 ,HIGH);
	else DIO_setPinValue(Port_C ,Pin0 ,LOW);



*/
