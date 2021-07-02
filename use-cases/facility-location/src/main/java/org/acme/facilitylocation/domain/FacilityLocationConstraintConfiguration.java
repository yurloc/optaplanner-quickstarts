/*
 * Copyright 2020 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.acme.facilitylocation.domain;

import org.optaplanner.core.api.domain.constraintweight.ConstraintConfiguration;
import org.optaplanner.core.api.domain.constraintweight.ConstraintWeight;
import org.optaplanner.core.api.score.buildin.hardsoftlong.HardSoftLongScore;

@ConstraintConfiguration
public class FacilityLocationConstraintConfiguration {

    static final String FACILITY_CAPACITY = "facility capacity";
    static final String FACILITY_SETUP_COST = "facility setup cost";
    static final String DISTANCE_FROM_FACILITY = "distance from facility";

    @ConstraintWeight(FACILITY_CAPACITY)
    final HardSoftLongScore facilityCapacity;
    @ConstraintWeight(FACILITY_SETUP_COST)
    final HardSoftLongScore facilitySetupCost;
    @ConstraintWeight(DISTANCE_FROM_FACILITY)
    final HardSoftLongScore distanceFromFacility;

    public FacilityLocationConstraintConfiguration(long facilityCapacity, long facilitySetupCost, long distanceFromFacility) {
        this.facilityCapacity = HardSoftLongScore.ofHard(facilityCapacity);
        this.facilitySetupCost = HardSoftLongScore.ofSoft(facilitySetupCost);
        this.distanceFromFacility = HardSoftLongScore.ofSoft(distanceFromFacility);
    }

    public FacilityLocationConstraintConfiguration() {
        this(1, 2, 5);
    }
}
