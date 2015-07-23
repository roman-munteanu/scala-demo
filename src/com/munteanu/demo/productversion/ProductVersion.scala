package com.munteanu.demo.productversion

/**
 * Created by romunteanu on 7/17/2015.
 */
case class ProductVersion (
                           productId: String,
                           majorVersion: Int,
                           minorVersion: Int,
                           plans: Option[List[PlanVersion]] = None,
                           states: Option[List[ProductVersionState]] = None

                            )
