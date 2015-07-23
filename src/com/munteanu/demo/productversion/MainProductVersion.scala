package com.munteanu.demo.productversion

/**
 * Created by romunteanu on 7/17/2015.
 */
object MainProductVersion extends App {

  val planVersionState1 = PlanVersionState("envId1", PlanVersionStateDeploymentStateEnum.published)
  val planVersionState2 = PlanVersionState("envId2", PlanVersionStateDeploymentStateEnum.staged)
  val planVersionState3 = PlanVersionState("envId3", PlanVersionStateDeploymentStateEnum.retired)

  val planVersion1 = PlanVersion(1, "planURL1", "planId1", Some(List(planVersionState1, planVersionState2)))
  val planVersion2 = PlanVersion(2, "planURL2", "planId2", Some(List(planVersionState3)))

  val productVersionState1 = ProductVersionState("envId1", ProductVersionStateStateEnum.ACTIVATING)
  val productVersionState2 = ProductVersionState("envId2", ProductVersionStateStateEnum.DEACTIVATING)

  val productVersion = ProductVersion("productId1", 1, 0,
    Some(List(planVersion1, planVersion2)),
    Some(List(productVersionState1, productVersionState2))
  )

  println("initial productVersion:")
  println(productVersion)

//  val newPlanVersions = productVersion.plans.map(planVersions => planVersions.map(planVersion => planVersion.copy(planId = "CUSTOM") ))


//  val newPlanVersionStates = productVersion.plans.get.foldLeft(List[PlanVersionState]()) { (z, f) =>
//    z ++ f.states.get.map(planVersionState => planVersionState.copy(deploymentState = null))
//  }
//  println("newPlanVersionStates:")
//  println(newPlanVersionStates)


//  val newPlans = productVersion.plans.get.map(planVersion => planVersion.copy(states = None))
  val newPlans = productVersion.plans.map(_.map(planVersion => planVersion.copy(states = None)))

  println("newPlans:")
  println(newPlans)

//  val newPlanVersions = productVersion.plans.map(planVersions => planVersions.map(planVersion => planVersion.copy(states = Some(newPlanVersionStates)) ))
//  println("newPlanVersions:")
//  println(newPlanVersions)

//  val newProductVersion = productVersion.copy(states = None, plans = Some(newPlans))
//  println("new productVersion:")
//  println(newProductVersion)
}
