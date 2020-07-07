/*
 * File: Subsystem1.h
 *
 * Code generated for Simulink model 'Subsystem1'.
 *
 * Model version                  : 1.0
 * Simulink Coder version         : 8.9 (R2015b) 13-Aug-2015
 * C/C++ source code generated on : Sun Jun 14 08:22:35 2020
 *
 * Target selection: ert.tlc
 * Embedded hardware selection: NXP->Cortex-M4
 * Code generation objectives: Unspecified
 * Validation result: Not run
 */

#ifndef RTW_HEADER_Subsystem1_h_
#define RTW_HEADER_Subsystem1_h_
#include <stddef.h>
#include <string.h>
#ifndef Subsystem1_COMMON_INCLUDES_
# define Subsystem1_COMMON_INCLUDES_
#include "rtwtypes.h"
#endif                                 /* Subsystem1_COMMON_INCLUDES_ */

#include "Subsystem1_types.h"

/* Macros for accessing real-time model data structure */
#ifndef rtmGetErrorStatus
# define rtmGetErrorStatus(rtm)        ((rtm)->errorStatus)
#endif

#ifndef rtmSetErrorStatus
# define rtmSetErrorStatus(rtm, val)   ((rtm)->errorStatus = (val))
#endif

/* Block states (auto storage) for system '<Root>' */
typedef struct {
  real_T BpzApz_states[2];             /* '<S1>/Bp(z)//Ap(z)' */
} DW_Subsystem1_T;

/* External inputs (root inport signals with auto storage) */
typedef struct {
  real_T In1;                          /* '<Root>/In1' */
} ExtU_Subsystem1_T;

/* External outputs (root outports fed by signals with auto storage) */
typedef struct {
  real_T Out1;                         /* '<Root>/Out1' */
} ExtY_Subsystem1_T;

/* Real-time Model Data Structure */
struct tag_RTM_Subsystem1_T {
  const char_T * volatile errorStatus;
};

/* Block states (auto storage) */
extern DW_Subsystem1_T Subsystem1_DW;

/* External inputs (root inport signals with auto storage) */
extern ExtU_Subsystem1_T Subsystem1_U;

/* External outputs (root outports fed by signals with auto storage) */
extern ExtY_Subsystem1_T Subsystem1_Y;

/* Model entry point functions */
extern void Subsystem1_initialize(void);
extern void Subsystem1_step(void);
extern void Subsystem1_terminate(void);

/* Real-time Model object */
extern RT_MODEL_Subsystem1_T *const Subsystem1_M;

/*-
 * The generated code includes comments that allow you to trace directly
 * back to the appropriate location in the model.  The basic format
 * is <system>/block_name, where system is the system number (uniquely
 * assigned by Simulink) and block_name is the name of the block.
 *
 * Note that this particular code originates from a subsystem build,
 * and has its own system numbers different from the parent model.
 * Refer to the system hierarchy for this subsystem below, and use the
 * MATLAB hilite_system command to trace the generated code back
 * to the parent model.  For example,
 *
 * hilite_system('System_20200614_0822_24/Subsystem1')    - opens subsystem System_20200614_0822_24/Subsystem1
 * hilite_system('System_20200614_0822_24/Subsystem1/Kp') - opens and selects block Kp
 *
 * Here is the system hierarchy for this model
 *
 * '<Root>' : 'System_20200614_0822_24'
 * '<S1>'   : 'System_20200614_0822_24/Subsystem1'
 */
#endif                                 /* RTW_HEADER_Subsystem1_h_ */

/*
 * File trailer for generated code.
 *
 * [EOF]
 */
