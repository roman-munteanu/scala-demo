package com.munteanu.demo.productversion

/**
 * Created by romunteanu on 7/17/2015.
 */
case class PlanVersionState (environmentId: String,
                             deploymentState: PlanVersionStateDeploymentStateEnum.Value

                              )
object PlanVersionStateDeploymentStateEnum extends Enumeration {
  type PlanVersionStateDeploymentStateEnumType = Value

  val published = Value("published")
  val staged = Value("staged")
  val retired = Value("retired")
}