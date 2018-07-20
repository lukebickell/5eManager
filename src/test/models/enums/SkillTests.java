package test.models.enums;

import main.models.enums.Attribute;
import main.models.enums.Skill;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SkillTests {

    @Test
    public void testStrengthSkills() {
        // Arrange
        List<Skill> strengthSkills = new ArrayList<>();
        strengthSkills.add(Skill.ATHLETICS);

        // Act
        List<Attribute> resultAttributes = new ArrayList<>();
        for (Skill skill: strengthSkills) {
            resultAttributes.add(skill.getAttribute());
        }

        // Assert
        for (Attribute attribute : resultAttributes) {
            Assertions.assertEquals(Attribute.STRENGTH, attribute);
        }
    }
}
