/*
 * KPD_Int.h
 *
 *  Created on: Sep 5, 2019
 *      Author: Mohamed Amr
 */

#ifndef KPD_INT_H_
#define KPD_INT_H_

/*
-Notes:
*******
	1.You must initialize the port you will use , configure it's direction (make sure you have 4 pins i/p & 4 pins o/p).
	2.Configure the Ports & Pins you used by writing it in the (Input_Pin , no_Of_Coloumn , ..) this conf. is from line(22 to 28) 
	3.you must declare a 2D array[no_Of_Coloumns][no_Of_Rows] first before calling The KPD_ScanKeys Function
*/

#include "GPIO_Int.h"
#define u8 	unsigned char

#define no_Of_Rows 4

#define no_Of_Coloumns 3

//#define Port_KPD Port_D

void KPD_ScanKeys(u8 KPD_Array[no_Of_Coloumns][no_Of_Rows], u8 Port_KPD);
short int KPD_getNumber(u8 KPD_Array[no_Of_Coloumns][no_Of_Rows]);
char* KPD_getPassword(u8 KPD_Array[no_Of_Coloumns][no_Of_Rows], u8 Port_KPD);

#endif /* KPD_INT_H_ */
