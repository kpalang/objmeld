package org.jmeld.ui;

import org.jmeld.diff.JMDelta;
import org.jmeld.diff.JMRevision;

/**
 * @author Kiran Ayyagari (kayyagari@apache.org)
 */
public interface DiffPanelIF {
    public JMRevision getCurrentRevision();
    public void doGotoDelta(JMDelta delta);
    public void doGotoLine(int line);
    public void toNextDelta(boolean next);
    public JMDelta getSelectedDelta();
    public void setSelectedDelta(JMDelta delta);
    public void runChange(int fromPanelIndex, int toPanelIndex, boolean shift);
    public void runDelete(int fromPanelIndex, int toPanelIndex);
    public ScrollableIF getFilePanel(int index);
}
