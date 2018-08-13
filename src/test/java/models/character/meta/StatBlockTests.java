package models.character.meta;

import models.character.enums.Attribute;
import models.character.enums.Skill;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StatBlockTests {

    @Test
    public void testGetModifierDefaultAttributes() {
        // Arrange
        StatBlock statBlock = new StatBlock();
        int[] expectedModifiers = new int[]{0, 0, 0, 0, 0, 0};

        // Act
        int i = 0;
        int[] resultModifiers = new int[6];
        for (Attribute attribute : statBlock.getAttributes().keySet()) {
            resultModifiers[i] = statBlock.getModifier(attribute);
            i++;
        }

        // Assert
        Assertions.assertArrayEquals(expectedModifiers, resultModifiers);
    }

    @Test
    public void testGetModifierEvenAttributes() {
        // Arrange
        StatBlock statBlock = new StatBlock();
        statBlock.setAttributeValue(Attribute.STRENGTH, 10);
        statBlock.setAttributeValue(Attribute.DEXTERITY, 12);
        statBlock.setAttributeValue(Attribute.CONSTITUTION, 14);
        statBlock.setAttributeValue(Attribute.INTELLIGENCE, 16);
        statBlock.setAttributeValue(Attribute.WISDOM, 18);
        statBlock.setAttributeValue(Attribute.CHARISMA, 20);

        int[] expectedModifiers = new int[]{0, 1, 2, 3, 4, 5};

        // Act
        int i = 0;
        int[] resultModifiers = new int[6];
        for (Attribute attribute : statBlock.getAttributes().keySet()) {
            resultModifiers[i] = statBlock.getModifier(attribute);
            i++;
        }

        // Assert
        Assertions.assertArrayEquals(expectedModifiers, resultModifiers);
    }

    @Test
    public void testGetModifierOddAttributes() {
        // Arrange
        StatBlock statBlock = new StatBlock();
        statBlock.setAttributeValue(Attribute.STRENGTH, 11);
        statBlock.setAttributeValue(Attribute.DEXTERITY, 13);
        statBlock.setAttributeValue(Attribute.CONSTITUTION, 15);
        statBlock.setAttributeValue(Attribute.INTELLIGENCE, 17);
        statBlock.setAttributeValue(Attribute.WISDOM, 19);
        statBlock.setAttributeValue(Attribute.CHARISMA, 21);

        int[] expectedModifiers = new int[]{0, 1, 2, 3, 4, 5};

        // Act
        int i = 0;
        int[] resultModifiers = new int[6];
        for (Attribute attribute : statBlock.getAttributes().keySet()) {
            resultModifiers[i] = statBlock.getModifier(attribute);
            i++;
        }

        // Assert
        Assertions.assertArrayEquals(expectedModifiers, resultModifiers);
    }

    @Test
    public void testGetModifierNegativeAttributes() {
        // Arrange
        StatBlock statBlock = new StatBlock();
        statBlock.setAttributeValue(Attribute.STRENGTH, 0);
        statBlock.setAttributeValue(Attribute.DEXTERITY, 1);
        statBlock.setAttributeValue(Attribute.CONSTITUTION, 4);
        statBlock.setAttributeValue(Attribute.INTELLIGENCE, 5);
        statBlock.setAttributeValue(Attribute.WISDOM, 8);
        statBlock.setAttributeValue(Attribute.CHARISMA, 9);

        int[] expectedModifiers = new int[]{-5, -4, -3, -2, -1, 0};

        // Act
        int i = 0;
        int[] resultModifiers = new int[6];
        for (Attribute attribute : statBlock.getAttributes().keySet()) {
            resultModifiers[i] = statBlock.getModifier(attribute);
            i++;
        }

        // Assert
        Assertions.assertArrayEquals(expectedModifiers, resultModifiers);
    }

    @Test
    public void testGetSkillModifierNoProficiency() {
        // Arrange
        StatBlock statBlock = new StatBlock();
        statBlock.setAttributeValue(Attribute.STRENGTH, 16);

        // Act
        int modifier = statBlock.getSkillModifier(Skill.ATHLETICS);

        // Assert
        Assertions.assertEquals(3, modifier);
    }

    @Test
    public void testGetSkillModifierWithProficiency() {
        // Arrange
        StatBlock statBlock = new StatBlock();
        statBlock.setAttributeValue(Attribute.WISDOM, 13);
        statBlock.setSkillProficiency(Skill.PERCEPTION, true);
        statBlock.setProficiency(2);

        // Act
        int modifier = statBlock.getSkillModifier(Skill.PERCEPTION);

        // Assert
        Assertions.assertEquals(3, modifier);
    }

    @Test
    public void testGetSkillModifierWithDoubleProficiency() {
        // Arrange
        StatBlock statBlock = new StatBlock();
        statBlock.setAttributeValue(Attribute.CHARISMA, 8);
        statBlock.setSkillProficiency(Skill.PERSUASION, true);
        statBlock.setSkillDoubleProficiency(Skill.PERSUASION, true);
        statBlock.setProficiency(3);

        // Act
        int modifier = statBlock.getSkillModifier(Skill.PERSUASION);

        // Assert
        Assertions.assertEquals(5, modifier);
    }
}
