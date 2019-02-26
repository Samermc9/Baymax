package com.baymax.discordBot.commands.mbti.meta;

import com.baymax.discordBot.assets.mbti.ImageURL;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Type {

    public static String type, letters, description, url, role, functionStack, fsDescription, percentage, percentageBar;
    public static Color color;
    public static ArrayList<String> list = new ArrayList<>(Arrays.asList("intp",
            "infp", "intj", "infj", "entj", "enfj", "enfp", "entp",
            "esfj", "istj", "isfj", "estj", "isfp", "istp", "esfp", "estp"));

    public static void intp() {
        type = "INTP";
        letters = "Introverted, Intuitive, Thinking, Perceiving";
        url = ImageURL.intp;
        role = "Analysts";
        color = new Color(107, 6, 55);
        functionStack = "[Ti] > [Ne] > [Si] > [Fe]";
        description = "The Logician personality type is fairly rare, making up only three percent of the population, which is definitely a good thing for them, " +
                "as there’s nothing they’d be more unhappy about than being “common”. Logicians pride themselves on their inventiveness and creativity, " +
                "their unique perspective and vigorous intellect. Usually known as the philosopher, the architect, or the dreamy professor," +
                " Logicians have been responsible for many scientific discoveries throughout history.";
        percentage = "3%";
        percentageBar = "██";

    }

    public static void intj() {
        type = "INTJ";
        letters = "Introverted, Intuitive, Thinking, Judging";
        url = ImageURL.intj;
        description = "get rekt";
        color = new Color(107, 6, 55);
        role = "Analysts";
        functionStack = "[Ni] > [Te] > [Fi] > [Se]";
        description = "It’s lonely at the top, and being one of the rarest and most strategically capable personality types, Architects know this all too well. Architects form just two percent of the population, and women of this personality type are especially rare, forming just 0.8% of the population – it is often a challenge for them to find like-minded individuals who are able to keep up with their relentless intellectualism and chess-like maneuvering." +
                " People with the Architect personality type are imaginative yet decisive, ambitious yet private, amazingly curious," +
                " but they do not squander their energy.";
        percentage = "2%";
        percentageBar = "█";
    }

    public static void entj() {
        type = "ENTJ";
        letters = "Extroverted, Intuitive, Thinking, Judging";
        url = ImageURL.entj;
        color = new Color(107, 6, 55);
        role = "Analysts";
        functionStack = "[Te] > [Ni] > [Se] > [Fi]";
        description = "Commanders are natural-born leaders. People with this personality type embody the gifts of charisma and confidence, and project authority in a way that draws crowds together behind a common goal. However, Commanders are also characterized by an often ruthless level of rationality, using their drive, determination and sharp minds to achieve whatever end they’ve set for themselves. Perhaps it is best that they make up only three percent of the population, lest they overwhelm the more timid and sensitive personality types that make up much of the rest of the world" +
                " – but we have Commanders to thank for many of the businesses and institutions we take for granted every day";
        percentage = "3%";
        percentageBar = "██";
    }

    public static void entp() {
        type = "ENTP";
        letters = "Extroverted, Intuitive, Thinking, Perceiving";
        url = ImageURL.entp;
        color = new Color(107, 6, 55);
        role = "Analysts";
        functionStack = "[Ne] > [Ti] > [Fe] > [Si]";
        description = "The Debater personality type is the ultimate devil’s advocate, thriving on the process of shredding arguments and beliefs and letting the ribbons drift in the wind for all to see. Debaters don’t do this because they are trying to achieve some deeper purpose or strategic goal, but for the simple reason that it’s fun. No one loves the process of mental sparring more than Debaters, as it gives them a chance to exercise their effortlessly quick wit," +
                " broad accumulated knowledge base, and capacity for connecting disparate ideas to prove their points.";
        percentage = "3%";
        percentageBar = "██";
    }

    public static void infp() {
        type = "INFP";
        letters = "Introverted, Intuitive, Feeling, Perceiving";
        url = ImageURL.infp;
        color = new Color(0, 255, 127);
        role = "Diplomats";
        functionStack = "[Fi] > [Ne] > [Si] > [Te]";
        description = "Mediator personalities are true idealists, always looking for the hint of good in even the worst of people and handlers, " +
                "searching for ways to make things better. While they may be perceived as calm, reserved, or even shy, Mediators have an inner flame and " +
                "passion that can truly shine. Comprising just 4% of the population, the risk of feeling misunderstood is unfortunately high for the Mediator " +
                "personality type – but when they find like-minded people to spend their time with, the harmony they feel" +
                " will be a fountain of joy and inspiration.";
        percentage = "4%";
        percentageBar = "██";
    }


    public static void infj() {
        type = "INFJ";
        letters = "Introverted, Intuitive, Feeling, Judging";
        url = ImageURL.infj;
        color = new Color(0, 255, 127);
        role = "Diplomats";
        functionStack = "[Ni] > [Fe] > [Ti] > [Se]";
        description = "The Advocate personality type is very rare, making up less than one percent of the population, but they nonetheless leave their mark on the world. As members of the Diplomat Role group, Advocates have an inborn sense of idealism and morality, but what sets them apart is that they are not idle dreamers, but people capable " +
                "of taking concrete steps to realize their goals and make a lasting positive impact.";
        percentage = "1%";
        percentageBar = "█";
    }

    public static void enfp() {
        type = "ENFP";
        letters = "Extroverted, Intuitive, Feeling, Perceiving";
        url = ImageURL.enfp;
        color = new Color(0, 255, 127);
        role = "Diplomats";
        functionStack = "[Ne] > [Fi] > [Te] > [Si]";
        description = "The Campaigner personality is a true free spirit. They are often the life of the party, but unlike types in the Explorer Role group, Campaigners are less interested in the sheer excitement and pleasure of the moment than they are in enjoying the social and emotional connections they make with others. Charming, independent, energetic and compassionate, " +
                "the 7% of the population that they comprise can certainly be felt in any crowd.";
        percentage = "7%";
        percentageBar = "█████";
    }

    public static void enfj() {
        type = "ENFJ";
        letters = "";
        url = ImageURL.enfj;
        color = new Color(0, 255, 127);
        role = "Diplomats";
        functionStack = "[Fe] > [Ni] > [Se] > [Ti]";
        description = "Protagonists are natural-born leaders, full of passion and charisma. Forming around two percent of the population, they are oftentimes our politicians, our coaches and our teachers, reaching out and inspiring others to achieve and to do good in the world. With a natural confidence that begets influence, Protagonists take a" +
                " great deal of pride and joy in guiding others to work together to improve themselves and their community.";
        percentage = "2%";
        percentageBar = "██";
    }

    public static void isfj() {
        type = "ISFJ";
        letters = "Introverted, Sensing, Thinking, Judging";
        url = ImageURL.isfj;
        color = new Color(11, 235, 255);
        role = "Sentinels";
        functionStack = "[Si] > [Fe] > [Ti] > [Ne]";
        description = "The Defender personality type is quite unique, as many of their qualities defy the definition of their individual traits. Though sensitive, Defenders have excellent analytical abilities; though reserved, they have well-developed people skills and robust social relationships; and though they are generally a conservative type, Defenders are often receptive to change and new ideas. As with so many things, people with the Defender personality type are more than the sum of their parts, and it is the way they " +
                "use these strengths that defines who they are.";
        percentage = "13%";
        percentageBar = "███████";
    }

    public static void istj() {
        type = "ISTJ";
        letters = "Introverted, Sensing, Thinking, Judging";
        url = ImageURL.istj;
        color = new Color(11, 235, 255);
        role = "Sentinels";
        functionStack = "[Si] > [Te] > [Fi] > [Ne]";
        description = "The Logistician personality type is thought to be the most abundant, making up around 13% of the population. " +
                "Their defining characteristics of integrity, practical logic and tireless dedication to duty make Logisticians a vital core to many " +
                "families, as well as organizations that uphold traditions, rules and standards, such as law offices, regulatory bodies and military." +
                " People with the Logistician personality type enjoy taking responsibility for their actions, and take pride in the work they do – when working" +
                " towards a goal, Logisticians hold back none of their time and energy completing each relevant task with accuracy and patience.";
        percentage = "12%";
        percentageBar = "███████";
    }

    public static void esfj() {
        type = "ESFJ";
        letters = "Extroverted, Sensing, Thinking, Perceiving";
        url = ImageURL.esfj;
        color = new Color(11, 235, 255);
        functionStack = "[Fe] > [Si] > [Ne] > [Ti]";
        percentage = "12%";
        percentageBar = "███████";
    }

    public static void estj() {
        type = "ESTJ";
        letters = "Extroverted, Sensing, Thinking, Judging";
        url = ImageURL.estj;
        color = new Color(11, 235, 255);
        role = "Sentinels";
        functionStack = "[Te] > [Si] > [Ne] > [Fi]";
        percentage = "11%";
        percentageBar = "███████";
    }

    public static void isfp() {
        type = "ISFP";
        letters = "Introverted, Sensing, Feeling, Perceiving";
        url = ImageURL.isfp;
        color = new Color(255, 233, 9);
        role = "Adventurers";
        functionStack = "[Fi] > [Se] > [Ni] > [Te]";
        description = "Adventurer personalities are true artists, but not necessarily in the typical sense where they’re out painting happy little trees. Often enough though, they are perfectly capable of this. Rather, it’s that they use aesthetics, design and even their choices and actions to push the limits of social convention. Adventurers enjoy upsetting traditional" +
                " expectations with experiments in beauty and behavior – chances are, they’ve expressed more than once the phrase “Don’t box me in!”";
        percentage = "7%";
        percentageBar = "█████";
    }

    public static void istp() {
        type = "ISTP";
        letters = "Introverted, Sensing, Thinking, Perceiving";
        url = ImageURL.istp;
        color = new Color(255, 233, 9);
        role = "Adventurer";
        functionStack = "[Ti] > [Se] > [Ni] > [Fe]";
        description = "Virtuosos love to explore with their hands and their eyes, touching and examining the world around them with cool rationalism " +
                "and spirited curiosity. People with this personality type are natural Makers, moving from project to project, building the useful and the superfluous for the fun of it, and learning from their environment as they go. Often mechanics and engineers, Virtuosos find no greater joy than in getting their " +
                "hands dirty pulling things apart and putting them back together, just a little bit better than they were before.";
        percentage = "5%";
        percentageBar = "████";
    }

    public static void esfp() {
        type = "ESFP";
        letters = "Extroverted, Sensing, Feeling, Perceiving";
        url = ImageURL.esfp;
        color = new Color(255, 233, 9);
        role = "Adventurer";
        functionStack = "[Se] > [Fi] > [Te] > [Ni]";
        description = "If anyone is to be found spontaneously breaking into song and dance, it is the Entertainer personality type. Entertainers get caught up in the excitement of the moment, and want everyone else to feel that way, too. No other personality type is as generous with their time and energy as Entertainers when it comes to encouraging others," +
                " and no other personality type does it with such irresistible style.";
        percentage = "9%";
        percentageBar = "██████";
    }


    public static void estp() {
        type = "ESTP";
        letters = "Extroverted, Sensing, Thinking, Perceiving";
        url = ImageURL.estp;
        color = new Color(255, 233, 9);
        role = "Adventurer";
        functionStack = "[Se] > [Ti] > [Fe] > [Ni]";
        description = "Entrepreneurs always have an impact on their immediate surroundings – the best way to spot them at a party is " +
                "to look for the whirling eddy of people flitting about them as they move from group to group. Laughing and entertaining with a blunt and earthy humor, Entrepreneur personalities love to be the center of attention. If an audience member is asked to come on stage, Entrepreneurs volunteer – or volunteer a shy friend. Theory, abstract concepts and plodding discussions " +
                "about global issues and their implications don’t keep Entrepreneurs interested for long. Entrepreneurs keep their conversation energetic, with" +
                " a good dose of intelligence, but they like to talk about what is – or better yet, to just go out and do it. " +
                "Entrepreneurs leap before they look, fixing their mistakes as they go, rather than sitting idle, preparing contingencies and " +
                "escape clauses.";
        percentage = "5%";
        percentageBar = "████";
    }


    public static void setFsDescription() {
        fsDescription = functionStack;
        fsDescription = fsDescription.replace("[Ti]", "Introverted Thinking");
        fsDescription = fsDescription.replace("[Te]", "Extroverted Thinking");
        fsDescription = fsDescription.replace("[Fi]", "Introverted Feeling");
        fsDescription = fsDescription.replace("[Fe]", "Extroverted Feeling");
        fsDescription = fsDescription.replace("[Ni]", "Introverted Intuiting");
        fsDescription = fsDescription.replace("[Ne]", "Extroverted Intuiting");
        fsDescription = fsDescription.replace("[Si]", "Introverted Sensing");
        fsDescription = fsDescription.replace("[Se]", "Extroverted Sensing");
    }
}
