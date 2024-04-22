import java.util.*;
public class Sound
{
  /** the array of values in this sound; guaranteed not to be null */
  int[] samples;



  /** Changes those values in this sound that have an amplitude greater than limit.
   *  Values greater than limit are changed to limit.
   *  Values less than -limit are changed to -limit.
   *  @param limit the amplitude limit
   *         Precondition: limit >= 0
   *  @return the number of values in this sound that this method changed
   */
  public int limitAmplitude(int limit)
  {  
    int numChanges = 0;
    for(int i = 0; i < samples.length; i++) {
      if(samples[i] > limit) { 
        samples[i] = limit;
        numChanges++;
      }
      if(samples[i] < -1*limit){
        samples[i] = -1*limit;
        numChanges++;
      }
    }
    return numChanges;
  }



  /** Removes all silence from the beginning of this sound.
   *  Silence is represented by a value of 0.
   *  Precondition: samples contains at least one nonzero value
   *  Postcondition: the length of samples reflects the removal of starting silence
   */
  public void trimSilenceFromBeginning()
  {
    int index = 0;
    while(samples[index] == 0) index++;
    int[] trimmedSamples = new int[samples.length - index];
    for(int i = 0; i < trimmedSamples.length; i++) {
      trimmedSamples[i] = samples[i + index];
    }
  }
}
