package com.munteanu.demo.productversion


/**
 * Created by romunteanu on 7/17/2015.
 */
case class PlanVersion (planVersion: Int,
                        planURL: String,
                        planId: String,
                        states: Option[List[PlanVersionState]] = None
                         )
