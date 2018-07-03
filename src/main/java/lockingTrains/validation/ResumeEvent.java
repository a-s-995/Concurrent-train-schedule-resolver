package lockingTrains.validation;

import lockingTrains.shared.Location;
import lockingTrains.shared.TrainSchedule;

/**
 * Event corresponding to {@link Recorder#resume}.
 */
public class ResumeEvent extends TrainEvent {
	private final TrainSchedule schedule;
	private final Location location;

	public ResumeEvent(final TrainSchedule schedule, final Location location) {
		this(System.currentTimeMillis(), schedule, location);
	}

	public ResumeEvent(final long timestamp, final TrainSchedule schedule, final Location location) {
		super(timestamp);
		this.schedule = schedule;
		this.location = location;
	}

	@Override
	public void replay(final Recorder recorder) {
		recorder.resume(timestamp, schedule, location);
	}

	@Override
	public String toString() {
		return String.format("%d: resume(%d,%s)", timestamp, schedule.id(), location.name());
	}
}
