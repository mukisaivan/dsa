
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Interval {

  int start;
  int end;

  public Interval(int start, int end) {
    this.start = start;
    this.end = end;
  }

  /*
   * -- merging overlapping intervals
   * QUESTION:
   * 
   * Given a list of intervals, merge all the overlapping intercals and return a
   * list of non-overlapping intervals
   * 
   * Exampple:
   * input: intervals = [{2,6}, {1,3}, {8,10}]
   * 
   * output: [{1,6}, {8,10}]
   * 
   * 
   */

  List<Interval> merge_overlapping_intervals(List<Interval> intervals) {

    if (intervals.size() < 2) {
      return intervals;
    }

    intervals.sort(Comparator.comparingInt(in -> in.start));

    List<Interval> result = new ArrayList<>();

    Interval first = intervals.get(0);

    int start = first.start;
    int end = first.end;

    for (int i = 1; i < intervals.size(); i++) {
      Interval current = intervals.get(i);
      if (current.start <= end) {
        end = Math.max(end, current.end);
      } else { // after encountering a boundary after updating the first overlapping interval
        result.add(new Interval(start, end));
        start = current.start;
        end = current.end;
      }
    }
    result.add(new Interval(start, end)); // doing it for the later intervals
    return result;
  }

  /*
   * -- inserting intervals
   * QUESTION:
   * 
   * given a list of non overlapping intervals sorted by thier tiime inser a given
   * interval at the valid position merge all the overlapping intervals and return
   * a list of mutually exclusive intervals
   * 
   * itnervals = [{1,3},{5,7},{8,10},{11,12}]
   * newInterval = [{4,9}]
   * 
   */

  List<Interval> insert_and_merge(List<Interval> intervals, Interval newInterval) {

    if (intervals == null || intervals.isEmpty()) {
      return intervals;
    }

    List<Interval> result = new LinkedList<>();

    int i = 0;

    // first portion
    while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
      result.add(intervals.get(i));
      i++;
    }

    // second portion
    while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
      Interval current = intervals.get(i);
      newInterval.start = Math.min(current.start, newInterval.start);
      newInterval.end = Math.max(current.end, newInterval.end);
      i++;
    }
    result.add(newInterval);

    // third portion
    while (i < intervals.size()) {
      result.add(intervals.get(i));
      i++;
    }

    return result;

  }

  public static void main(String[] args) {

  }

}
