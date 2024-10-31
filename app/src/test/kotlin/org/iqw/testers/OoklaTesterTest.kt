package org.iqw.testers

import org.junit.jupiter.api.Test

class OoklaTesterTest {
    val typicalOoklaJson = TypicalOoklaData.typicalJson

    /**
     * Can we extract information from the Ookla return.
     *
     * Given information of typical format from the Ookla binary
     * can we extract key information.
     */
    @Test
    fun extractInformationWorksAsExpected(){
        extractInformation()
    }

}