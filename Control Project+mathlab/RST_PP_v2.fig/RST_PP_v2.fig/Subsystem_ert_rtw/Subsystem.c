/*
 * File: Subsystem.c
 *
 * Code generated for Simulink model 'Subsystem'.
 *
 * Model version                  : 1.0
 * Simulink Coder version         : 8.9 (R2015b) 13-Aug-2015
 * C/C++ source code generated on : Sun Jun 14 08:32:42 2020
 *
 * Target selection: ert.tlc
 * Embedded hardware selection: NXP->Cortex-M4
 * Code generation objectives: Unspecified
 * Validation result: Not run
 */

#include "Subsystem.h"
#include "Subsystem_private.h"

/* Block states (auto storage) */
DW_Subsystem_T Subsystem_DW;

/* External inputs (root inport signals with auto storage) */
ExtU_Subsystem_T Subsystem_U;

/* External outputs (root outports fed by signals with auto storage) */
ExtY_Subsystem_T Subsystem_Y;

/* Real-time model */
RT_MODEL_Subsystem_T Subsystem_M_;
RT_MODEL_Subsystem_T *const Subsystem_M = &Subsystem_M_;

/* Model step function */
void Subsystem_step(void)
{
  real_T uSz_tmp;

  /* DiscreteFilter: '<S1>/1//S(z)' incorporates:
   *  DiscreteFilter: '<S1>/R(z)'
   *  DiscreteFilter: '<S1>/T(z)'
   *  Inport: '<Root>/In1'
   *  Inport: '<Root>/In2'
   *  Sum: '<S1>/Sum1'
   */
  uSz_tmp = ((((3.3333 * Subsystem_U.In1 + -4.5807 * Subsystem_DW.Tz_states[0])
               + 1.6225 * Subsystem_DW.Tz_states[1]) - ((3.0 * Subsystem_U.In2 +
    -3.939 * Subsystem_DW.Rz_states[0]) + 1.3142 * Subsystem_DW.Rz_states[1])) -
             -0.3742 * Subsystem_DW.uSz_states[0]) - -0.6258 *
    Subsystem_DW.uSz_states[1];

  /* Outport: '<Root>/Out1' incorporates:
   *  DiscreteFilter: '<S1>/1//S(z)'
   */
  Subsystem_Y.Out1 = uSz_tmp;

  /* Update for DiscreteFilter: '<S1>/T(z)' incorporates:
   *  Inport: '<Root>/In1'
   */
  Subsystem_DW.Tz_states[1] = Subsystem_DW.Tz_states[0];
  Subsystem_DW.Tz_states[0] = Subsystem_U.In1;

  /* Update for DiscreteFilter: '<S1>/R(z)' incorporates:
   *  Inport: '<Root>/In2'
   */
  Subsystem_DW.Rz_states[1] = Subsystem_DW.Rz_states[0];
  Subsystem_DW.Rz_states[0] = Subsystem_U.In2;

  /* Update for DiscreteFilter: '<S1>/1//S(z)' */
  Subsystem_DW.uSz_states[1] = Subsystem_DW.uSz_states[0];
  Subsystem_DW.uSz_states[0] = uSz_tmp;
}

/* Model initialize function */
void Subsystem_initialize(void)
{
  /* Registration code */

  /* initialize error status */
  rtmSetErrorStatus(Subsystem_M, (NULL));

  /* states (dwork) */
  (void) memset((void *)&Subsystem_DW, 0,
                sizeof(DW_Subsystem_T));

  /* external inputs */
  (void) memset((void *)&Subsystem_U, 0,
                sizeof(ExtU_Subsystem_T));

  /* external outputs */
  Subsystem_Y.Out1 = 0.0;
}

/* Model terminate function */
void Subsystem_terminate(void)
{
  /* (no terminate code required) */
}

/*
 * File trailer for generated code.
 *
 * [EOF]
 */
