/*
 * Copyright (C) 1998-2019 Gerwin Klein <lsf@jflex.de>
 * Copyright (C) 2008-2019 Steve Rowe <sarowe@gmail.com>
 * Copyright (C) 2017-2020 Google, LLC.
 *
 * SPDX-License-Identifier: BSD-3-Clause
 */
package jflex.core.unicode;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import jflex.chars.Interval;

// DO NOT EDIT
// This class was automatically generated by //java/de/jflex/ucd_generator
// based on Unicode data files downloaded from unicode.org.
/**
 * Unicode properties that can be bound to a specific Unicode version.
 *
 * <p>Supported unicode versions are defined in {@link #UNICODE_VERSIONS}.
 */
public class UnicodeProperties {

  /** Human-readable list of all supported Unicode versions. */
  public static final String UNICODE_VERSIONS =
      "1.1, 1.1.5, 2, 2.0, 2.0.14, 2.1, 2.1.9, 3, 3.0, 3.0.1, 3.1, 3.1.1, 3.2, 3.2.0, 4, 4.0,"
          + " 4.0.1, 4.1, 4.1.0, 5, 5.0, 5.0.0, 5.1, 5.1.0, 5.2, 5.2.0, 6, 6.0, 6.0.0, 6.1, 6.1.0,"
          + " 6.2, 6.2.0, 6.3, 6.3.0, 7, 7.0, 7.0.0, 8, 8.0, 8.0.0, 9, 9.0, 9.0.0, 10, 10.0,"
          + " 10.0.0, 11, 11.0, 11.0.0, 12, 12.0, 12.0.0, 12.1, 12.1.0";

  private static final String DEFAULT_UNICODE_VERSION = "12.1";

  private static final Pattern WORD_SEP_PATTERN = Pattern.compile("[-_\\s()]");

  private int maximumCodePoint;
  private final Map<String, IntCharSet> propertyValueIntervals = new HashMap<>();
  private String caselessMatchPartitions;
  private int caselessMatchPartitionSize;
  private IntCharSet[] caselessMatches;

  /**
   * Unpacks the Unicode data corresponding to the default Unicode version.
   *
   * @throws UnsupportedUnicodeVersionException if the default version is not supported.
   */
  public UnicodeProperties() throws UnsupportedUnicodeVersionException {
    init(DEFAULT_UNICODE_VERSION);
  }

  /**
   * Unpacks the Unicode data corresponding to the given version.
   *
   * @param version The Unicode version for which to unpack data
   * @throws UnsupportedUnicodeVersionException if the given version is not supported.
   */
  public UnicodeProperties(String version) throws UnsupportedUnicodeVersionException {
    init(version);
  }

  /**
   * Returns the maximum code point for the selected Unicode version.
   *
   * @return the maximum code point for the selected Unicode version.
   */
  public int getMaximumCodePoint() {
    return maximumCodePoint;
  }

  /**
   * Returns the character interval set associated with the given property value for the selected
   * Unicode version.
   *
   * @param propertyValue The Unicode property or property value (or alias for one of these) for
   *     which to return the corresponding character intervals.
   * @return The character interval set corresponding to the given property value, if a match
   *     exists, and null otherwise.
   */
  public IntCharSet getIntCharSet(String propertyValue) {
    return propertyValueIntervals.get(normalize(propertyValue));
  }

  /**
   * Returns the set of all properties, property values, and their aliases supported by the
   * specified Unicode version.
   *
   * @return The set of all properties supported by the specified Unicode version
   */
  public Set<String> getPropertyValues() {
    return propertyValueIntervals.keySet();
  }

  /**
   * Returns a set of character intervals representing all characters that are case-insensitively
   * equivalent to the given character, including the given character itself.
   *
   * <p>The first call to this method lazily initializes the backing data.
   *
   * @param c The character for which to return case-insensitive equivalents.
   * @return All case-insensitively equivalent characters, or null if the given character is
   *     case-insensitively equivalent only to itself.
   */
  public IntCharSet getCaselessMatches(int c) {
    if (null == caselessMatches) initCaselessMatches();
    return caselessMatches[c];
  }

  /**
   * Unpacks the caseless match data. Called from {@link #getCaselessMatches(int)} to lazily
   * initialize.
   */
  private void initCaselessMatches() {
    caselessMatches = new IntCharSet[maximumCodePoint + 1];
    int[] members = new int[caselessMatchPartitionSize];
    for (int index = 0; index < caselessMatchPartitions.length(); ) {
      IntCharSet partition = new IntCharSet();
      for (int n = 0; n < caselessMatchPartitionSize; ++n) {
        int c = caselessMatchPartitions.codePointAt(index);
        index += Character.charCount(c);
        members[n] = c;
        if (c > 0) partition.add(c); // ignore trailing zero padding
      }
      if (partition.containsElements()) {
        for (int n = 0; n < caselessMatchPartitionSize; ++n) {
          if (members[n] > 0) caselessMatches[members[n]] = partition;
        }
      }
    }
  }

  /**
   * Based on the given version, selects and binds the corresponding Unicode data to facilitate
   * mappings from property values to character intervals.
   *
   * @param version The Unicode version for which to bind data
   * @throws UnsupportedUnicodeVersionException if the given version is not supported.
   */
  private void init(String version) throws UnsupportedUnicodeVersionException {
    switch (version) {
      case "1.1":
      case "1.1.5":
        bind(
            jflex.core.unicode.data.Unicode_1_1.propertyValues,
            jflex.core.unicode.data.Unicode_1_1.intervals,
            jflex.core.unicode.data.Unicode_1_1.propertyValueAliases,
            jflex.core.unicode.data.Unicode_1_1.maximumCodePoint,
            jflex.core.unicode.data.Unicode_1_1.caselessMatchPartitions,
            jflex.core.unicode.data.Unicode_1_1.caselessMatchPartitionSize);
        break;
      case "2":
      case "2.0":
      case "2.0.14":
        bind(
            jflex.core.unicode.data.Unicode_2_0.propertyValues,
            jflex.core.unicode.data.Unicode_2_0.intervals,
            jflex.core.unicode.data.Unicode_2_0.propertyValueAliases,
            jflex.core.unicode.data.Unicode_2_0.maximumCodePoint,
            jflex.core.unicode.data.Unicode_2_0.caselessMatchPartitions,
            jflex.core.unicode.data.Unicode_2_0.caselessMatchPartitionSize);
        break;
      case "2.1":
      case "2.1.9":
        bind(
            jflex.core.unicode.data.Unicode_2_1.propertyValues,
            jflex.core.unicode.data.Unicode_2_1.intervals,
            jflex.core.unicode.data.Unicode_2_1.propertyValueAliases,
            jflex.core.unicode.data.Unicode_2_1.maximumCodePoint,
            jflex.core.unicode.data.Unicode_2_1.caselessMatchPartitions,
            jflex.core.unicode.data.Unicode_2_1.caselessMatchPartitionSize);
        break;
      case "3":
      case "3.0":
      case "3.0.1":
        bind(
            jflex.core.unicode.data.Unicode_3_0.propertyValues,
            jflex.core.unicode.data.Unicode_3_0.intervals,
            jflex.core.unicode.data.Unicode_3_0.propertyValueAliases,
            jflex.core.unicode.data.Unicode_3_0.maximumCodePoint,
            jflex.core.unicode.data.Unicode_3_0.caselessMatchPartitions,
            jflex.core.unicode.data.Unicode_3_0.caselessMatchPartitionSize);
        break;
      case "3.1":
      case "3.1.1":
        bind(
            jflex.core.unicode.data.Unicode_3_1.propertyValues,
            jflex.core.unicode.data.Unicode_3_1.intervals,
            jflex.core.unicode.data.Unicode_3_1.propertyValueAliases,
            jflex.core.unicode.data.Unicode_3_1.maximumCodePoint,
            jflex.core.unicode.data.Unicode_3_1.caselessMatchPartitions,
            jflex.core.unicode.data.Unicode_3_1.caselessMatchPartitionSize);
        break;
      case "3.2":
      case "3.2.0":
        bind(
            jflex.core.unicode.data.Unicode_3_2.propertyValues,
            jflex.core.unicode.data.Unicode_3_2.intervals,
            jflex.core.unicode.data.Unicode_3_2.propertyValueAliases,
            jflex.core.unicode.data.Unicode_3_2.maximumCodePoint,
            jflex.core.unicode.data.Unicode_3_2.caselessMatchPartitions,
            jflex.core.unicode.data.Unicode_3_2.caselessMatchPartitionSize);
        break;
      case "4":
      case "4.0":
      case "4.0.1":
        bind(
            jflex.core.unicode.data.Unicode_4_0.propertyValues,
            jflex.core.unicode.data.Unicode_4_0.intervals,
            jflex.core.unicode.data.Unicode_4_0.propertyValueAliases,
            jflex.core.unicode.data.Unicode_4_0.maximumCodePoint,
            jflex.core.unicode.data.Unicode_4_0.caselessMatchPartitions,
            jflex.core.unicode.data.Unicode_4_0.caselessMatchPartitionSize);
        break;
      case "4.1":
      case "4.1.0":
        bind(
            jflex.core.unicode.data.Unicode_4_1.propertyValues,
            jflex.core.unicode.data.Unicode_4_1.intervals,
            jflex.core.unicode.data.Unicode_4_1.propertyValueAliases,
            jflex.core.unicode.data.Unicode_4_1.maximumCodePoint,
            jflex.core.unicode.data.Unicode_4_1.caselessMatchPartitions,
            jflex.core.unicode.data.Unicode_4_1.caselessMatchPartitionSize);
        break;
      case "5":
      case "5.0":
      case "5.0.0":
        bind(
            jflex.core.unicode.data.Unicode_5_0.propertyValues,
            jflex.core.unicode.data.Unicode_5_0.intervals,
            jflex.core.unicode.data.Unicode_5_0.propertyValueAliases,
            jflex.core.unicode.data.Unicode_5_0.maximumCodePoint,
            jflex.core.unicode.data.Unicode_5_0.caselessMatchPartitions,
            jflex.core.unicode.data.Unicode_5_0.caselessMatchPartitionSize);
        break;
      case "5.1":
      case "5.1.0":
        bind(
            jflex.core.unicode.data.Unicode_5_1.propertyValues,
            jflex.core.unicode.data.Unicode_5_1.intervals,
            jflex.core.unicode.data.Unicode_5_1.propertyValueAliases,
            jflex.core.unicode.data.Unicode_5_1.maximumCodePoint,
            jflex.core.unicode.data.Unicode_5_1.caselessMatchPartitions,
            jflex.core.unicode.data.Unicode_5_1.caselessMatchPartitionSize);
        break;
      case "5.2":
      case "5.2.0":
        bind(
            jflex.core.unicode.data.Unicode_5_2.propertyValues,
            jflex.core.unicode.data.Unicode_5_2.intervals,
            jflex.core.unicode.data.Unicode_5_2.propertyValueAliases,
            jflex.core.unicode.data.Unicode_5_2.maximumCodePoint,
            jflex.core.unicode.data.Unicode_5_2.caselessMatchPartitions,
            jflex.core.unicode.data.Unicode_5_2.caselessMatchPartitionSize);
        break;
      case "6":
      case "6.0":
      case "6.0.0":
        bind(
            jflex.core.unicode.data.Unicode_6_0.propertyValues,
            jflex.core.unicode.data.Unicode_6_0.intervals,
            jflex.core.unicode.data.Unicode_6_0.propertyValueAliases,
            jflex.core.unicode.data.Unicode_6_0.maximumCodePoint,
            jflex.core.unicode.data.Unicode_6_0.caselessMatchPartitions,
            jflex.core.unicode.data.Unicode_6_0.caselessMatchPartitionSize);
        break;
      case "6.1":
      case "6.1.0":
        bind(
            jflex.core.unicode.data.Unicode_6_1.propertyValues,
            jflex.core.unicode.data.Unicode_6_1.intervals,
            jflex.core.unicode.data.Unicode_6_1.propertyValueAliases,
            jflex.core.unicode.data.Unicode_6_1.maximumCodePoint,
            jflex.core.unicode.data.Unicode_6_1.caselessMatchPartitions,
            jflex.core.unicode.data.Unicode_6_1.caselessMatchPartitionSize);
        break;
      case "6.2":
      case "6.2.0":
        bind(
            jflex.core.unicode.data.Unicode_6_2.propertyValues,
            jflex.core.unicode.data.Unicode_6_2.intervals,
            jflex.core.unicode.data.Unicode_6_2.propertyValueAliases,
            jflex.core.unicode.data.Unicode_6_2.maximumCodePoint,
            jflex.core.unicode.data.Unicode_6_2.caselessMatchPartitions,
            jflex.core.unicode.data.Unicode_6_2.caselessMatchPartitionSize);
        break;
      case "6.3":
      case "6.3.0":
        bind(
            jflex.core.unicode.data.Unicode_6_3.propertyValues,
            jflex.core.unicode.data.Unicode_6_3.intervals,
            jflex.core.unicode.data.Unicode_6_3.propertyValueAliases,
            jflex.core.unicode.data.Unicode_6_3.maximumCodePoint,
            jflex.core.unicode.data.Unicode_6_3.caselessMatchPartitions,
            jflex.core.unicode.data.Unicode_6_3.caselessMatchPartitionSize);
        break;
      case "7":
      case "7.0":
      case "7.0.0":
        bind(
            jflex.core.unicode.data.Unicode_7_0.propertyValues,
            jflex.core.unicode.data.Unicode_7_0.intervals,
            jflex.core.unicode.data.Unicode_7_0.propertyValueAliases,
            jflex.core.unicode.data.Unicode_7_0.maximumCodePoint,
            jflex.core.unicode.data.Unicode_7_0.caselessMatchPartitions,
            jflex.core.unicode.data.Unicode_7_0.caselessMatchPartitionSize);
        break;
      case "8":
      case "8.0":
      case "8.0.0":
        bind(
            jflex.core.unicode.data.Unicode_8_0.propertyValues,
            jflex.core.unicode.data.Unicode_8_0.intervals,
            jflex.core.unicode.data.Unicode_8_0.propertyValueAliases,
            jflex.core.unicode.data.Unicode_8_0.maximumCodePoint,
            jflex.core.unicode.data.Unicode_8_0.caselessMatchPartitions,
            jflex.core.unicode.data.Unicode_8_0.caselessMatchPartitionSize);
        break;
      case "9":
      case "9.0":
      case "9.0.0":
        bind(
            jflex.core.unicode.data.Unicode_9_0.propertyValues,
            jflex.core.unicode.data.Unicode_9_0.intervals,
            jflex.core.unicode.data.Unicode_9_0.propertyValueAliases,
            jflex.core.unicode.data.Unicode_9_0.maximumCodePoint,
            jflex.core.unicode.data.Unicode_9_0.caselessMatchPartitions,
            jflex.core.unicode.data.Unicode_9_0.caselessMatchPartitionSize);
        break;
      case "10":
      case "10.0":
      case "10.0.0":
        bind(
            jflex.core.unicode.data.Unicode_10_0.propertyValues,
            jflex.core.unicode.data.Unicode_10_0.intervals,
            jflex.core.unicode.data.Unicode_10_0.propertyValueAliases,
            jflex.core.unicode.data.Unicode_10_0.maximumCodePoint,
            jflex.core.unicode.data.Unicode_10_0.caselessMatchPartitions,
            jflex.core.unicode.data.Unicode_10_0.caselessMatchPartitionSize);
        break;
      case "11":
      case "11.0":
      case "11.0.0":
        bind(
            jflex.core.unicode.data.Unicode_11_0.propertyValues,
            jflex.core.unicode.data.Unicode_11_0.intervals,
            jflex.core.unicode.data.Unicode_11_0.propertyValueAliases,
            jflex.core.unicode.data.Unicode_11_0.maximumCodePoint,
            jflex.core.unicode.data.Unicode_11_0.caselessMatchPartitions,
            jflex.core.unicode.data.Unicode_11_0.caselessMatchPartitionSize);
        break;
      case "12":
      case "12.0":
      case "12.0.0":
        bind(
            jflex.core.unicode.data.Unicode_12_0.propertyValues,
            jflex.core.unicode.data.Unicode_12_0.intervals,
            jflex.core.unicode.data.Unicode_12_0.propertyValueAliases,
            jflex.core.unicode.data.Unicode_12_0.maximumCodePoint,
            jflex.core.unicode.data.Unicode_12_0.caselessMatchPartitions,
            jflex.core.unicode.data.Unicode_12_0.caselessMatchPartitionSize);
        break;
      case "12.1":
      case "12.1.0":
        bind(
            jflex.core.unicode.data.Unicode_12_1.propertyValues,
            jflex.core.unicode.data.Unicode_12_1.intervals,
            jflex.core.unicode.data.Unicode_12_1.propertyValueAliases,
            jflex.core.unicode.data.Unicode_12_1.maximumCodePoint,
            jflex.core.unicode.data.Unicode_12_1.caselessMatchPartitions,
            jflex.core.unicode.data.Unicode_12_1.caselessMatchPartitionSize);
        break;
      default:
        throw new UnsupportedUnicodeVersionException();
    }
  }

  /**
   * Unpacks data for the selected Unicode version, populating {@link #propertyValueIntervals}.
   *
   * @param propertyValues The list of property values, in same order as the packed data
   *     corresponding to them, in the given intervals, for the selected Unicode version.
   * @param intervals The packed character intervals corresponding to and in the same order as the
   *     given propertyValues, for the selected Unicode version.
   * @param propertyValueAliases Key/value pairs mapping property value aliases to property values,
   *     for the selected Unicode version.
   * @param maximumCodePoint The maximum code point for the selected Unicode version.
   * @param caselessMatchPartitions The packed caseless match partition data for the selected
   *     Unicode version
   * @param caselessMatchPartitionSize The partition data record length (the maximum number of
   *     elements in a caseless match partition) for the selected Unicode version.
   */
  private void bind(
      String[] propertyValues,
      String[] intervals,
      String[] propertyValueAliases,
      int maximumCodePoint,
      String caselessMatchPartitions,
      int caselessMatchPartitionSize) {
    // IntCharSet caselessMatches[] is lazily initialized - don't unpack here
    this.caselessMatchPartitions = caselessMatchPartitions;
    this.caselessMatchPartitionSize = caselessMatchPartitionSize;
    this.maximumCodePoint = maximumCodePoint;
    for (int n = 0; n < propertyValues.length; ++n) {
      String propertyValue = propertyValues[n];
      String propertyIntervals = intervals[n];
      IntCharSet set = new IntCharSet();
      for (int index = 0; index < propertyIntervals.length(); ) {
        int start = propertyIntervals.codePointAt(index);
        index += Character.charCount(start);
        int end = propertyIntervals.codePointAt(index);
        index += Character.charCount(end);
        set.add(new Interval(start, end));
      }
      propertyValueIntervals.put(propertyValue, set);
      if (2 == propertyValue.length()) {
        String singleLetter = propertyValue.substring(0, 1);
        IntCharSet singleLetterPropValueSet = propertyValueIntervals.get(singleLetter);
        if (null == singleLetterPropValueSet) {
          singleLetterPropValueSet = new IntCharSet();
          propertyValueIntervals.put(singleLetter, singleLetterPropValueSet);
        }
        singleLetterPropValueSet.add(set);
      }
    }
    // We expect the length of propertyValueAliases to be divisible by 2 (alias/value pairs)
    assert 0 == propertyValueAliases.length % 2;
    for (int n = 0; n < propertyValueAliases.length - 1; n += 2) {
      String alias = propertyValueAliases[n];
      String propertyValue = propertyValueAliases[n + 1];
      IntCharSet targetSet = propertyValueIntervals.get(propertyValue);
      if (null != targetSet) {
        propertyValueIntervals.put(alias, targetSet);
      }
    }
    bindInvariantIntervals();
  }

  /** Adds intervals for \p{ASCII} and \p{Any} to {@link #propertyValueIntervals}. */
  private void bindInvariantIntervals() {
    IntCharSet asciiSet = IntCharSet.ofCharacterRange(0, 0x7F);
    propertyValueIntervals.put(normalize("ASCII"), asciiSet);

    IntCharSet anySet = IntCharSet.ofCharacterRange(0, maximumCodePoint);
    propertyValueIntervals.put(normalize("Any"), anySet);
  }

  /**
   * Normalizes the given identifier, by: downcasing; removing whitespace, underscores, hyphens, and
   * parentheses; and substituting '=' for every ':'.
   *
   * @param identifier The identifier to normalize
   * @return The normalized identifier
   */
  private static String normalize(String identifier) {
    if (null == identifier) return identifier;
    Matcher matcher = WORD_SEP_PATTERN.matcher(identifier.toLowerCase(Locale.ENGLISH));
    return matcher.replaceAll("").replace(':', '=');
  }

  public static class UnsupportedUnicodeVersionException extends Exception {
    private static final long serialVersionUID = -1718158223161422981L;

    public UnsupportedUnicodeVersionException() {
      super("Supported versions: " + UNICODE_VERSIONS);
    }

    public UnsupportedUnicodeVersionException(Throwable cause) {
      super("Supported versions: " + UNICODE_VERSIONS, cause);
    }
  }
}
