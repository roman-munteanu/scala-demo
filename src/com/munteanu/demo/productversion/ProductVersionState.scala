package com.munteanu.demo.productversion

/**
 * Created by romunteanu on 7/17/2015.
 */
case class ProductVersionState (environmentId: String,
                                state: ProductVersionStateStateEnum.Value

                                 )

object ProductVersionStateStateEnum extends Enumeration {
  type ProductVersionStateStateEnumType = Value

  val ACTIVATED = Value("ACTIVATED")
  val ACTIVATING = Value("ACTIVATING")
  val DEACTIVATED = Value("DEACTIVATED")
  val DEACTIVATING = Value("DEACTIVATING")
  val STAGING = Value("STAGING")
  val STAGED = Value("STAGED")
}
