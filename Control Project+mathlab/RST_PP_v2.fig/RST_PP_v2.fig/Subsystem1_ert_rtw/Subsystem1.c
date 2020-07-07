/*
 * File: Subsystem1.c
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

#include "Subsystem1.h"
#include "Subsystem1_private.h"

/* Block states (auto storage) */
DW_Subsystem1_T Subsystem1_DW;

/* External inputs (root inport signals with auto storage) */
ExtU_Subsystem1_T Subsystem1_U;

/* External outputs (root outports fed by signals with auto storage) */
ExtY_Subsystem1_T Subsystem1_Y;

/* Real-time model */
RT_MODEL_Subsystem1_T Subsystem1_M_;
RT_MODEL_Subsystem1_T *const Subsystem1_M = &Subsystem1_M_;

/* Model step function */
void Subsystem1_step(void)
{
  real_T rtb_BpzApz;

  /* Outport: '<Root>/Out1' incorporates:
   *  DiscreteFilter: '<S1>/Bp(z)//Ap(z)'
   */
  Subsystem1_Y.Out1 = 0.1 * Subsystem1_DW.BpzApz_states[0] + 0.2 *
    Subsystem1_DW.BpzApz_states[1];

  /* Update for DiscreteFilter: '<S1>/Bp(z)//Ap(z)' incorporates:
   *  Update for Inport: '<Root>/In1'
   */
  rtb_BpzApz = (Subsystem1_U.In1 - -1.3 * Subsystem1_DW.BpzApz_states[0]) - 0.42
    * Subsystem1_DW.BpzApz_states[1];
  Subsystem1_DW.BpzApz_states[1] = Subsystem1_DW.BpzApz_states[0];
  Subsystem1_DW.BpzApz_states[0] = rtb_BpzApz;
}

/* Model initialize function */
void Subsystem1_initialize(void)
{
  /* Registration code */

  /* initialize error status */
  rtmSetErrorStatus(Subsystem1_M, (NULL));

  /* states (dwork) */
  (void) memset((void *)&Subsystem1_DW, 0,
                sizeof(DW_Subsystem1_T));

  /* external inputs */
  Subsystem1_U.In1 = 0.0;

  /* external outputs */
  Subsystem1_Y.Out1 = 0.0;
}

/* Model terminate function */
void Subsystem1_terminate(void)
{
  /* (no terminate code required) */
}

/*
 * File trailer for generated code.
 *
 * [EOF]
 */
