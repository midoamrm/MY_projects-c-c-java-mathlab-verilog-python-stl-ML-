/*
 * GPIO_Int.h
 *
 *  Created on: Aug 23, 2019
 *      Author: Mohamed Amr
 */

#ifndef GPIO_INT_H_
#define GPIO_INT_H_

#include "stdint.h"

#define u8 	unsigned char

#define Pin0 0
#define Pin1 1
#define Pin2 2
#define Pin3 3
#define Pin4 4
#define Pin5 5
#define Pin6 6
#define Pin7 7

#define Port_A 0
#define Port_B 1
#define Port_C 2
#define Port_D 3
#define Port_E 4
#define Port_F 5

#define HIGH 1
#define LOW 0

#define INPUT 0
#define OUTPUT 1

void GPIO_init(u8 Port);
u8 GPIO_setPullUpResistor(u8 Port , u8 value);
u8 GPIO_setPinValue(u8 Port , u8 Pin , u8 value);
u8 GPIO_getPinValue(u8 Port , u8 Pin , u8* level);
u8 GPIO_setPinDirection(u8 Port , u8 Pin , u8 direction);
u8 GPIO_setPortDirection(u8 Port , u8 directions);
u8 GPIO_setPortValue(u8 Port , u8 value);



#endif /* GPIO_INT_H_ */
